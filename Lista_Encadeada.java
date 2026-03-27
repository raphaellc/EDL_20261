package main;

public class Lista_Encadeada<T> {

	private No<T> inicio;
	private int Size;
	
		public Lista_Encadeada() {
			this.inicio = null;
			this.Size = 0;
		}
	
		public void add(T Dado) {
			
			if (this.inicio == null) {
				this.inicio = new No<T>(Dado);
				return;
			}
			
			No<T> No_Aux_Add = this.inicio;
			
			while(No_Aux_Add.Get_Prox() != null) {
				No_Aux_Add = No_Aux_Add.Get_Prox();
				}
			
			No_Aux_Add.Set_Prox(new No<T>(Dado));
			Size++;
		}
		
		public void Show_All_Elements(T Dado) {
			if (inicio == null) {
				System.out.println("Empty... mpty... MTY... M T. . . ___");
				this.inicio = new No<T>(Dado);
			}
			
			No<T> No_Aux_Show = this.inicio;
			
			while (No_Aux_Show.Get_Prox() != null) {
				System.out.println(No_Aux_Show.Get_Dado());
				No_Aux_Show.Get_Prox();
			}
			
		}
		
}