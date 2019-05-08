package com.xuxx.spike.vo.spike;

import java.math.BigDecimal;
import java.util.Date;

import com.xuxx.spike.entity.SpikeProductInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ConstomSpikeProduct  extends SpikeProductInfo {
	private BigDecimal startSpikePrice;//��ɱ�۸��ѯ��Χ��ʼ
	private BigDecimal endmSpikePrice;//��ɱ�۸��ѯ��Χ����
	
	private BigDecimal startOriginalPrice;//��Ʒԭ�۲�ѯ��Χ��ʼ
	private BigDecimal endOriginalPrice;//��Ʒԭ�۲�ѯ��Χ����
	
	private Date startApplyDate;//����ʱ���ѯ��Χ��ʼʱ��
	private Date endApplyDate;//����ʱ���ѯ��Χ����ʱ��
	
	private Date startAuditDate;//���ʱ���ѯ��Χ��ʼʱ��
	private Date endAuditDate;//���ʱ���ѯ��Χ����ʱ��
	
	private Date startStartTime;//��ɱ��ʼʱ���ѯ��Χ��ʼʱ��
	private Date endStartTime;//��ɱ��ʼʱ���ѯ��Χ����ʱ��
	
	private Date startEndTime;//��ɱ����ʱ���ѯ��Χ��ʼʱ��
	private Date endEndTime;//��ɱ����ʱ���ѯ��Χ����ʱ��
	
	private int startProductCount;//��ɱ��Ʒ����ʼ��Χ
	private int endProductCount;//��ɱ��Ʒ��������Χ
	
	private int startStockCount;//��濪ʼ��Χ
	private int endStockCount;//��������Χ
}