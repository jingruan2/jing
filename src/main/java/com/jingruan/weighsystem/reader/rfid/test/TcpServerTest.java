package com.jingruan.weighsystem.reader.rfid.test;

import com.jingruan.weighsystem.reader.rfid.AppNotifyImpl.MRfidReaderNotifyImpl;
import com.jingruan.weighsystem.reader.rfid.transport.RfidReaderManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;


public class TcpServerTest {



	@Test
	public void test() throws IOException {
		System.out.println("the program will start as being tcp server.");
		MRfidReaderNotifyImpl appNotify = new MRfidReaderNotifyImpl();
		RfidReaderManager.initilizeTransportManager(appNotify);
		try {
			RfidReaderManager.getInstance().CreateTcpServer(9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("the port main be used" );
		}

		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}
	}

}
