package paging;

import lombok.Getter;
import lombok.Setter;

public class page {
	
	/** ���� ������ ��ȣ */
	private int currentPageNo;

	/** �������� ����� ������ ���� */
	private int recordsPerPage;

	/** ȭ�� �ϴܿ� ����� ������ ������ */
	private int pageSize;

	/** �˻� Ű���� */
	private String searchKeyword;

	/** �˻� ���� */
	private String searchType;

	public page() {
		this.currentPageNo = 1;
		this.recordsPerPage = 10;
		this.pageSize = 10;
	}

	public int getStartPage() {
		return (currentPageNo - 1) * recordsPerPage;
	}

}
