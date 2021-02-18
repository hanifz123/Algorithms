import java.util.*;

public class MatrikSnek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input m length: ");
		int mMatrix = sc.nextInt();
		System.out.println("input n length: ");
		int nMatrix = sc.nextInt();
		int[][] hasil = spiral(mMatrix,nMatrix);
		printSpiral(hasil);
		
	}

	public static int[][] spiral(int mMatrix, int nMatrix) { //m baris, n kolom
		int[][] matSpiral = new int[mMatrix][nMatrix];
		int square = mMatrix*nMatrix;
		
		int cont = 0;int val = 1;
		//baris pertama 0,0
		do {
			System.out.println("kanan");
			int iKanan = 0+cont; int iTurun = 0+cont;
			while(iKanan<nMatrix) {
				matSpiral[iTurun][iKanan] = val;
				System.out.println(iTurun+" "+iKanan+++" "+val++);
				if (iKanan>nMatrix-1) {
					break; 
				}
				
			}
			if(val>square) { 
				break;
			}
			System.out.println("turun");
			iKanan -= 1; iTurun +=1;
			while(iTurun<mMatrix) {
				matSpiral[iTurun][iKanan] = val;
				System.out.println(iTurun+++" "+iKanan+" "+val++);
				if (iTurun>mMatrix-1) {
					break;
				}
				
			}
			if(val>square) { 
				break;
			}
			System.out.println("kiri");
			iKanan -=1; iTurun -=1; int iKiri = iKanan; 
			while(iKiri>=cont) {
				matSpiral[iTurun][iKiri]= val;
				System.out.println(iTurun+" "+iKiri--+" "+val++);
				if (iKiri<cont) {
					break; 
				}
				
			}
			if(val>square) { 
				break;
			}
			iKiri +=1; iTurun -=1;
			System.out.println("naik");
			while(iTurun>=cont) {
				matSpiral[iTurun][iKiri] = val;
				System.out.println(iTurun--+" "+iKiri+" "+val++);
				if (iTurun<=cont) {
					break; 
				} 
				
			}
//			System.out.println("loopdone"+iTurun+" "+iKiri);
			nMatrix -=1;
			mMatrix -=1;
			cont++;
		}while(val<=square);
		
		return matSpiral;
	}
	
	public static void printSpiral(int[][] hasil) {
		for(int i = 0 ; i<hasil.length;i++) {
			System.out.println("\n");
			for(int j = 0; j<hasil[i].length;j++)
				System.out.print("["+hasil[i][j]+"]"+"\t");
		}
	}
}

