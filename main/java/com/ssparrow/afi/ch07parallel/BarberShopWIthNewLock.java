package com.ssparrow.afi.ch07parallel;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarberShopWIthNewLock {
	private Lock lock=new ReentrantLock();
	private Condition barberRestCondition = lock.newCondition();
	private Condition barberBusyCondition = lock.newCondition();
	private AtomicBoolean isBusy =new AtomicBoolean(false);
	
	
	private Barber barber=new Barber("hippo");
	private BarberChair barberChair=new BarberChair(1);
	private BlockingQueue<Customer> queue=new LinkedBlockingQueue<BarberShopWIthNewLock.Customer>();
	
	
	
	public BarberShopWIthNewLock() {
		new Thread(new BarberChairHandler()).start();
		new Thread(new BarberQueueHandler()).start();
		
	}
	
	public void handle(Customer customer){
		new Thread(new CustomerHandler(customer)).start();
	}

	private class BarberChairHandler implements Runnable{

		@Override
		public void run() {
			while(true){
				
				if (lock.tryLock()) {
					try {
						Customer customer;

						while ((customer = barber.getCustomer()) == null) {
							barberRestCondition.await();
						}

						System.out.println(customer + "successfully took barber service");
						isBusy.set(true);

						barber.serve(customer);

						isBusy.set(false);

						barber.rest();

						barberBusyCondition.signalAll();

					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}

				} else {
					System.out.println("oops, too slow, another customer already take the barber chair, he will try to wait in queue");
				}
				
			}
			
		}
		
	
	}	
	
	private class BarberQueueHandler implements Runnable{

		@Override
		public void run() {
			while(true){
				
				Customer customer = null;
				try {
					customer = queue.take();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				System.out.println("barber take "+customer+" from the waiting queue");
				
				if (lock.tryLock()) {
					try {

						while (isBusy.get()) {
							barberBusyCondition.await();
						}

						System.out.println("barber start to serve " + customer);
						
						isBusy.set(true);

						barber.serve(customer);

						isBusy.set(false);

					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}

				} else {
					System.out.println("oops,"+ customer+ "is too slow, another customer already take the barber chair");
					queue.offer(customer);
				}
				
			}
			
		}
		
	
	}
	
	
	private class CustomerHandler implements Runnable{
		private Customer customer;

		public CustomerHandler(Customer customer) {
			this.customer = customer;
		}


		@Override
		public void run() {
			if(isBusy.get() || !queue.isEmpty()){
				System.out.println("the barber is busy,"+customer+" will try to wait in queue");
				boolean result = queue.offer(customer);
				if(!result){
					System.out.println("bad luck, all waiting chairs are taken, "+customer+" leaves");
				}
				return;
			}
			
			if(lock.tryLock()){
				try {
					barber.wakeup(customer);
				}finally{
					lock.unlock();
				}
			}
		}
		
	}
	
	
	
	private class BarberChair{
		private int id;

		public BarberChair(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "BarberChair [id=" + id + "]";
		}
		
		
	}
	
	private class Barber{
		private Customer customer;
		private String name;

		@Override
		public String toString() {
			return "Barber [name=" + name + "]";
		}

		public Barber(String name) {
			super();
			this.name = name;
		}
		
		public void serve(Customer customer) throws InterruptedException{
			int serveTime=new Random().nextInt(5)+1;
			System.out.println(this+" is serving "+customer+", will take "+serveTime+"seconds ");
			Thread.sleep(serveTime*1000);
			System.out.println(this+" finished serving "+customer);
		}
		
		public void rest() throws InterruptedException{
			this.customer=null;
			barberRestCondition.await();
		}
		
		public void wakeup(Customer customer){
			this.customer=customer;
			barberRestCondition.signalAll();
		}

		public Customer getCustomer() {
			return customer;
		}
		
	}
	
	public static class Customer{
		private String name;

		@Override
		public String toString() {
			return "Customer [name=" + name + "]";
		}

		public Customer(String name) {
			super();
			this.name = name;
		}
		
	}

}
