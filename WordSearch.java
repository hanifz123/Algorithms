import java.util.*;

public class WordSearch {

	// {3 3 3 catt aata tatc cat 5 5 gogog ooooo godog ooooo 
	// gogog dog 2 8 bananana kalibrrr nana}
	
	// scanner input test case
	// 		testcase ulang proses search sebanyak T
	// 			testcase panggil proses searchword
	// 			searchword terima input berapa line string x brp char
	// 				input dijadiin data
	// 			prosesing
	// 			return nilai per test case x:c
	// 	   ulang testcase lagi, hasil prosesing disimpan diarray test case
	// test case print hasil pake fungsi for enhance
	
	public static void main(String[] args) {
		WordSearch w = new WordSearch();
		Scanner s = new Scanner(System.in);
		int iterasi = s.nextInt();
		String[] arr = new String[iterasi];
		
		arr = w.testCase(iterasi);
		
		for(String out : arr) {
			System.out.println(out);
		}	
		s.close();
	} 
	
	public String[] testCase(int t) {
		Scanner st = new Scanner(System.in);
		String[] hasil = new String[t];
		for(int i = 0; i<t; i++) {
			int x; int y; String key;
			x = st.nextInt();
			String[] word = new String[x];
			y = st.nextInt();
			for(int inword = 0; inword<x;inword++) {
				word[inword] = st.next();
			}
			key = st.next();
			hasil[i] = "Case "+(i+1)+": "+searchWord(word.length,word[0].length(),word,key);
			//parameter input x y still uses word length
		}
		st.close();
		return hasil; //nanti print hasil 1 1 di main
	}
	
	public String searchWord(int gridrow, int gridcol, String[] word, String boardkey) {
		char[][] board = new char[gridrow][gridcol];
		char[] key = boardkey.toCharArray();
		//pecah word jadi char
		for(int i = 0; i<board.length;i++) {
			for(int j = 0; j<board[i].length;j++) {
				board[i][j] = word[i].charAt(j);
//				System.out.println(board[i][j]+"\n");
			}
		}
		int h = searchHor(board, boardkey);
		int v = searchVer(board, boardkey);
		int d = searchDia(gridrow, gridcol, board, boardkey);
		int hvd = h+v+d;
		String hasil = Integer.toString(hvd);
		return hasil; //dummy saja
	}
	
	public int searchHor(char[][] board, String boardkey) {
		int foundHor = 0; String entri;String trien;
		for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
            	if(c+boardkey.length() > board[r].length) {
            		break;
            	}
            	else {
                	entri = String.valueOf(board[r],c,boardkey.length());
                	trien = reverse(entri);
                	if(entri.equals(boardkey)==true) {
                		foundHor++;
                	}
                	if(trien.equals(boardkey)==true) {
                		foundHor++;
                	}
                	else if(entri.equals(boardkey)!=true) {
                		continue;
                	}
            	}	
            }
        }
		return foundHor;
	}
	
	public int searchVer(char[][] tboard, String boardkey) {
		int foundVer = 0; String entri;String trien; 
		int lenx = tboard.length; int leny = tboard[0].length;
		char[][] board = new char[leny][lenx];
		//transpose
		for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
            	board[r][c] = tboard[c][r];
            }
		}
		for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
            	if(c+boardkey.length() > board[r].length) {
            		break;
            	}
            	else {
                	entri = String.valueOf(board[r],c,boardkey.length());
                	trien = reverse(entri);
                	if(entri.equals(boardkey)==true) {
                		foundVer++;
                	}
                	if(trien.equals(boardkey)==true) {
                		foundVer++;
                	}
                	else if(entri.equals(boardkey)!=true) {
                		continue;
                	}
            	}	
            }
        }
		return foundVer;
	}
	
	public int searchDia(int gridrow, int gridcol, char[][] board, String boardkey) {
		int foundDia = 0; String entri;String trien; 

		for(int r = 0; r<gridrow;r++) {
			for(int c = 0; c<gridcol;c++) {
				char[] search = new char[boardkey.length()];
				for(int s = 0; s<boardkey.length();s++) {
					int rs = r+s, cs = c+s;
					if(rs>=gridrow || cs>=gridcol) {
						continue;
					}
					search[s] = board[rs][cs];
					rs++; cs++;
				}
				entri = String.valueOf(search);
				if(entri.equals(boardkey)==true) {
					foundDia++;
				}
				else if(entri.equals(boardkey)!=true) {
					continue;
				}
			}	
		}
		for(int r = gridrow-1; r>=0;r--) {
			for(int c = gridcol-1; c>=0;c--) {
				char[] search = new char[boardkey.length()];
				for(int s = 0; s<boardkey.length();s++) {
					int rs = r-s, cs = c-s;
					if(rs<0 || cs<0) {
						continue;
					}
					search[s] = board[rs][cs];
					rs--; cs--;
				}
				entri = String.valueOf(search);
				if(entri.equals(boardkey)==true) {
					foundDia++;
				}
				else if(entri.equals(boardkey)!=true) {
					continue;
				}
			}	
		}
		for(int r = 0; r<gridrow;r++) {
			for(int c = gridcol-1; c>=0;c--) {
				char[] search = new char[boardkey.length()];
				for(int s = 0; s<boardkey.length();s++) {
					int rs = r+s, cs = c-s;
					if(rs>=gridrow ||cs<0) {
						continue;
					}
					search[s] = board[rs][cs];
					rs++; cs--;
				}
				entri = String.valueOf(search);
				if(entri.equals(boardkey)==true) {
					foundDia++;
				}
				else if(entri.equals(boardkey)!=true) {
					continue;
				}
			}	
		}
		for(int r = 0; r<gridrow;r++) {
			for(int c = gridcol-1; c>=0;c--) {
				char[] search = new char[boardkey.length()];
				for(int s = 0; s<boardkey.length();s++) {
					int rs = r+s, cs = c-s;
					if(rs>=gridrow || cs<0) {
						continue;
					}
					search[s] = board[rs][cs];
					rs++; cs--;
				}
				entri = String.valueOf(search);
				if(entri.equals(boardkey)==true) {
					foundDia++;
				}
				else if(entri.equals(boardkey)!=true) {
					continue;
				}
			}	
		}
		return foundDia;
	}
	
	public static String reverse(String str) {
        if (str == null || str.equals(""))
            return str;
        int n = str.length();
        char[] temp = new char[n];
        for (int i = 0; i < n; i++)
            temp[n - i - 1] = str.charAt(i);
        return String.copyValueOf(temp);
    }

}
