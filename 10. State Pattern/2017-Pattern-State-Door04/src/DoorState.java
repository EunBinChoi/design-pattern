
public enum DoorState {
	OPENED{
		@Override
		public DoorState open() {
			System.out.println("�̹� ���� ����");
			return this;
		}

		@Override
		public DoorState close() {
			System.out.println("���� ����");
			return CLOSED;
		}

		@Override
		public DoorState lock() {
			System.out.println("���� ���� �־� ��� �� ����");
			return this;
		}

		@Override
		public DoorState unlock() {
			System.out.println("���� ��� ���� ����");
			return this;
		}
	}, 
	CLOSED{
		@Override
		public DoorState open() {
			System.out.println("���� ����");
			return OPENED;
		}

		@Override
		public DoorState close() {
			System.out.println("���� �̹� ���� ����");
			return this;
		}

		@Override
		public DoorState lock() {
			System.out.println("���� ���");
			return LOCKED;
		}

		@Override
		public DoorState unlock() {
			System.out.println("���� ��� ���� ����");
			return this;
		}
	}, 
	LOCKED{
		@Override
		public DoorState open() {
			System.out.println("���� ��� �־� �� �� ����");
			return this;
		}

		@Override
		public DoorState close() {
			System.out.println("���� ��� �־� ���� �ʿ䰡 ����");
			return this;
		}

		@Override
		public DoorState lock() {
			System.out.println("���� �̹� ��� ����");
			return this;
		}

		@Override
		public DoorState unlock() {
			System.out.println("���� ����� ������");
			return CLOSED;
		}
	};
	public abstract DoorState open();
	public abstract DoorState close();
	public abstract DoorState lock();
	public abstract DoorState unlock();
}
