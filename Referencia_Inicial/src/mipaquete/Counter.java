package mipaquete;

public class Counter {
	public int value;
	public int maxValue;
	public String model;

	public Counter() {
		this.value = 0;
		this.maxValue = 100_000;
		this.model = "N-COUNTER";
	}

	public Counter(int maximoValor) {
		this.maxValue = maximoValor;
	}

	public Counter(String modelo, int maximoValor) {
		this.maxValue = maximoValor;
		this.model = modelo;
	}
	
	public Counter (Counter contador) {
		this.value = contador.value;
		this.maxValue = contador.maxValue;
		this.model = contador.model;
	}

	public void show() {
		System.out.println("Contador: modelo (" + this.model + ") y valor " + this.value + " de " + this.maxValue);
	}

//	public boolean increment() {
//		if (this.value < this.maxValue) {
//			this.value++;
//			return true;
//		}
//
//		else
//			return false;
//	}
	
	public boolean increment() {
		return increment(1);
	}

	public boolean increment(int n) {
		if (this.value + n <= this.maxValue) {
			this.value += n;
			return true;
		}

		else {
			this.value = this.maxValue;
			return false;
		}
	}

	public boolean reset() {
		if (this.value == this.maxValue) {
			this.value = 0;
			return true;
		}

		else {
			this.value = 0;
			return false;
		}
	}

	public static void main(String[] args) {
		Counter c1 = new Counter();
		c1.show();
		Counter c2 = new Counter("Modelo A", 5);
		c2.show();
		Counter c3 = new Counter(1000);
		c3.show();
		Counter c4 = new Counter(c2);
		c4.show();
		System.out.println("======");
		c2.show();
		for (int i = 0; i < 3; i++) {
			System.out.println(c2.increment(2));			
		}
		c2.show();
		System.out.println(c2.reset());
		c2.show();
		
	}

}
