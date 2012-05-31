package com.ssparrow.afi.ch07parallel;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BarberShop {
	Barber barber=new Barber("hippo");
	BarberChair barberChair=new BarberChair(1);

	BlockingQueue<Customer> queue=new LinkedBlockingQueue<BarberShop.Customer>(10);
	
	public BarberShop() {
		new Thread(new BarberHandler()).start();
	}
	
	public void handle(Customer customer){
		new Thread(new CustomerHandler(customer)).start();
	}
	
	private class BarberHandler implements Runnable{

		@Override
		public void run() {
			
			while(true){
				try {
					while(queue.isEmpty() || barberChair.hasCustomer()){
						Thread.sleep(100);
					}
					
					Customer customer = queue.take();
					barberChair.requestService(customer);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
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

			try {
				if (queue.isEmpty()) {
					barberChair.requestService(customer);
				}
				
				
				System.out.println(customer +"come, but barber  is busy, he will try to find a chair");
				boolean result = queue.offer(customer);
				if(!result){
					System.out.println(customer +" was not able to find a chair, he left");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	private class Barber{
		private String name;

		public Barber(String name) {
			this.name = name;
		}
		
		public void rest(BarberChair barberChair){
			barberChair.rest(this);
		}
		
		public void serve(BarberChair barberChair, Customer customer) throws InterruptedException{
			int serveTime=new Random().nextInt(10);
			Thread.sleep(serveTime*1000);
		}

		@Override
		public String toString() {
			return "Barber [name=" + name + "]";
		}
		
		
		
	}
	
	public static class Customer{
		private String name;
		private WaitChair waitChair;

		public Customer(String name) {
			this.name = name;
		}
		
		public void sitdown(WaitChair waitChair){
			this.waitChair=waitChair;
			waitChair.setCustomer(this);
		}
		
		public void standup(){
			this.waitChair=null;
			waitChair.removeCustomer();
		}

		@Override
		public String toString() {
			return "Customer [name=" + name + "]";
		}
		
		
	}
	
	private class BarberChair{
		int id;
		private Customer customer;

		public BarberChair(int id) {
			this.id = id;
		}

		private synchronized void removeCustomer() {
			customer=null;;
		}
		
		public synchronized void rest(Barber barber) {
			System.out.println(barber + " is resting on "+this);
		}
		
		public synchronized boolean hasCustomer(){
			return customer!=null;
		}

		private synchronized  Customer getCustomer() {
			return customer;
		}

		public synchronized void setCustomer(Customer customer) {
			this.customer = customer;
		}
		
		public synchronized void requestService(Customer customer) throws InterruptedException{
			System.out.println(barber +" start to serve "+customer);
			this.setCustomer(customer);
			barber.serve(this, customer);
			this.finishService(customer);
			return;
		}
		
		public synchronized void finishService(Customer customer){
			System.out.println(barber +" finish serving "+customer);
			this.removeCustomer();
			barber.rest(this);
			return;
		}

		@Override
		public String toString() {
			return "BarberChair [id=" + id + "]";
		}
		
		
		
	}
	
	private static class WaitChair{
		private int id;
		private Customer customer;

		public WaitChair(int id) {
			this.id = id;
		}

		public void removeCustomer() {
			customer=null;;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		
		
	}
}
