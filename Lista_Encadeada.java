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
		
		public void Show_All_Elements(T Dado, No<T> Prox) {
			if (inicio == null) {
				System.out.println("Empty... mpty... MTY... M T. . . ___");
				this.inicio = new No<T>(Dado);
			}
			
			No<T> No_Aux_Show = this.inicio;
			
			System.out.println(No_Aux_Show.Get_Dado());
			
			while (No_Aux_Show.Get_Prox() != null) {
				No_Aux_Show = No_Aux_Show.Get_Prox();
				System.out.println(No_Aux_Show.Get_Dado());
			}		
			
		}
		
		public boolean remover(int position) {
			
			if (this.inicio == null) { return false; }
			
			else if (position <= this.Size) { 
				
				int current_pos = 0;
				No<T> No_Aux_Remov = this.inicio;
				No<T> No_Ant_Remov = null;
				
					if (position == 0) {
					this.inicio = No_Aux_Remov.Get_Prox();
					Size--;
					return true;
					}
				
					else {	
					
				while (current_pos < position -1) {
					
					No_Ant_Remov = No_Aux_Remov;
					No_Aux_Remov = No_Aux_Remov.Get_Prox();
					
					current_pos++;
					
				}
				
				No_Ant_Remov.Set_Prox(No_Aux_Remov.Get_Prox());
				Size--;
				return true;
					}
					
			}
			
			return true;
		}
	
}
