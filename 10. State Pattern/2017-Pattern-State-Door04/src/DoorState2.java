// ������� ���� �ܼ� ���ڿ� ����� �ʿ� ���� ���
// �⺻ �޼ҵ带 �����ϸ�, �� ���¸� �����ϱ� ������ �� ����
public enum DoorState2 {
	OPENED{
		@Override
		public DoorState2 close() {
			return CLOSED;
		}
	}, 
	CLOSED{
		@Override
		public DoorState2 open() {
			return OPENED;
		}
		@Override
		public DoorState2 lock() {
			return LOCKED;
		}
	}, 
	LOCKED{
		@Override
		public DoorState2 unlock() {
			return CLOSED;
		}
	};
	public DoorState2 open(){ return this; }
	public DoorState2 close(){ return this; }
	public DoorState2 lock(){ return this; }
	public DoorState2 unlock(){ return this; }
}
