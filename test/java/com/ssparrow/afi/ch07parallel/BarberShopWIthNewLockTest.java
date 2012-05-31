package com.ssparrow.afi.ch07parallel;

import java.util.Random;

import com.ssparrow.afi.ch07parallel.BarberShopWIthNewLock.Customer;


public class BarberShopWIthNewLockTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		BarberShopWIthNewLock barberShop=new BarberShopWIthNewLock();
		
		int id=1;
		for (int i = 0; i < 10; i++) {
			if(i%2==0){
				Customer customer1=new Customer(String.valueOf(id++));
				Customer customer2=new Customer(String.valueOf(id++));
				
				barberShop.handle(customer1);
				barberShop.handle(customer2);
			}else{
				Customer customer=new Customer(String.valueOf(id++));
				
				barberShop.handle(customer);
			}
			
			int waitTime=new Random().nextInt(2)+1;
			Thread.sleep(waitTime*1000);
		}
		
		System.out.print("total "+(id-1)+" customers");
	}

}
