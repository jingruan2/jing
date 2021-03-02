package com.jingruan.weighsystem.reader.rfid.AppNotifyImpl;

import com.jingruan.weighsystem.reader.rfid.reader.AppNotify;
import com.jingruan.weighsystem.reader.rfid.reader.RfidReader;
import com.jingruan.weighsystem.reader.rfid.transport.RfidReaderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;


public class MRfidReaderNotifyImpl implements AppNotify {



	RfidReader reader = null;
	@Override
	public String NotifyRecvOneTag(RfidReader reader, String epcData,
								String tidData) throws IOException {
		// TODO Auto-generated method stub
		//System.out.print("Receive a tag.");
		if (epcData != null && epcData.length() != 0){
			System.out.print(epcData);

		}
		
		if (null != tidData && tidData.length()!= 0){
			System.out.print("TID Area Data: "+ tidData);
		}
		return epcData;
	}

	@Override
	public void NotifyNewTcpConnectAvailable(RfidReader reader) {
		// TODO Auto-generated method stub
		this.reader = reader;
		try {
			RfidReaderManager.getInstance().AcceptNewReaderConnect(reader);
			System.out.println("accept new reader connect.");
			//���Ͷ������Ҳ���Բ��÷���
			reader.Inventory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void NotifyRebootRsp(RfidReader reader, int status) {
		// TODO Auto-generated method stub
		if (0 == status){
			System.out.println("the reader will be reboot.");
		}else {
			System.out.println("Fail to reboot.");
		}
	}

	@Override
	public void NotifySetDefaultParamRsp(RfidReader reader, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NotifyStartInventoryRsp(RfidReader reader, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NotifyStopInventoryRsp(RfidReader reader, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NotifyWriteTagRsp(RfidReader reader, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NotifyReadTagRsp(RfidReader reader, int status,
								 byte[] readTagData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NotifyRemoteCloseConnection(RfidReader reader) {
		// TODO Auto-generated method stub
		System.out.println("remote "+ reader.getKey() + " disconnect.");
	}
}
