// ���ϸ� : HandType.java

// ��ü���ⰳ�߷� �� �ǽ� Laboratory 1_���ο� �˰��� ����
// ������ : ����� ������
// �й� : 1�й�
// �к� : ��ǻ�Ͱ��к� 
// �й� : 2014136129
// �̸� : ������

public enum HandType { // ���� ����� �������ִ� ������
	GAWI { // ����
		@Override
		public String toString() { // �ش�Ǵ� ���� ����� ���ڿ��� ������ִ� �Լ�
			return "����";
		}

		@Override
		public HandType winValueOf() { // ������ ���� ��翡�� �̱�� ���� ����� �������ִ� �Լ�
			return BAWI; 
		}
	},
	BAWI { // ����
		@Override
		public String toString() { // �ش�Ǵ� ���� ����� ���ڿ��� ������ִ� �Լ�
			return "����";
		}

		@Override
		public HandType winValueOf() { // ������ ���� ��翡�� �̱�� ���� ����� �������ִ� �Լ�
			return BO;
		}
	},
	BO { // ��
		@Override
		public String toString() { // �ش�Ǵ� ���� ����� ���ڿ��� ������ִ� �Լ�
			return "��";
		}

		@Override
		public HandType winValueOf() { // ������ ���� ��翡�� �̱�� ���� ����� �������ִ� �Լ�
			return GAWI;
		}
	};


	// ������ ���� ��翡�� �̱�� ���� ����� �������ִ� �Լ�
	public abstract HandType winValueOf();

	// �ش��ϴ� �ε��� ���� ���� ����� �������� ��ȯ���ִ� �Լ�
	// �ε��� 0 => ����, 1=> ����, 2=>��
	public static HandType valueOf(int n) {
		return HandType.values()[n]; 
	}
}