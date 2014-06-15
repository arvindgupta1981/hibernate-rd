package com.mkyong;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockId(25);
        stock.setStockCode("43082");
        stock.setStockName("AdddNIt");
        //session.merge(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setRecordId(4);
        stockDailyRecords.setPriceOpen(new Float("1.29452"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        Date date = new Date();
        date.setDate(1);
        stockDailyRecords.setDate(date);
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        session.merge(stockDailyRecords);
        session.getTransaction().commit();
		session.flush();
		
		
		Query query = session.createQuery("from Stock where id = :id");
		query.setParameter("id", 25);
        Stock stk = (Stock) query.list().get(0);
        System.out.println("code:" + stk.getStockCode());
        
        query = session.createQuery("select stockName,stockCode from Stock where id = :id");
		query.setParameter("id", 25);
        Object[] stkArr = (Object[]) query.list().get(0);
        System.out.println("code:" + stkArr[1]);
		
		
		System.out.println("Done");
		
		
		
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		StockDailyRecord dailyRecord = (StockDailyRecord) session.load(StockDailyRecord.class, 4);
		dailyRecord.setStock(null);
		session.delete(dailyRecord);
		session.getTransaction().commit();
		
		
	}
}
