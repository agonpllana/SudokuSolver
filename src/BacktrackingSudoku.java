import java.util.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner; 
public class BacktrackingSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] easy1 = {{ 1, 5, 0, 0, 4, 2, 0, 0, 6 }, 
						 { 2, 7, 4, 5, 6, 0, 0, 1, 0 }, 
						 { 0, 0, 6, 0, 0, 7, 4, 0, 2 },
						 { 0, 1, 0, 0, 0, 0, 0, 4, 0 }, 
						 { 0, 0, 0, 0, 5, 0, 0, 0, 0 }, 
						 { 0, 6, 0, 4, 0, 3, 1, 9, 0 },
						 { 0, 2, 0, 6, 0, 5, 9, 0, 0 }, 
						 { 9, 8, 5, 0, 3, 0, 0, 6, 0 }, 
						 { 0, 4, 0, 2, 1, 9, 8, 3, 0 } };
		
		int[][] easy2 ={  { 6, 0, 0, 1, 0, 0, 0, 0, 2 }, 
						  { 8, 0, 1, 0, 9, 0, 0, 0, 0 }, 
						  { 0, 7, 5, 0, 8, 4, 0, 0, 0 },
						  { 4, 3, 0, 0, 2, 0, 5, 6, 1 }, 
						  { 5, 1, 8, 7, 0, 0, 4, 0, 9 }, 
						  { 0, 9, 6, 4, 1, 0, 3, 0, 0 },
						  { 0, 0, 0, 0, 7, 0, 0, 0, 0 }, 
						  { 0, 6, 0, 0, 3, 1, 0, 5, 0 }, 
						  { 7, 0, 2, 5, 4, 0, 6, 0, 3 } };
		
		int[][] easy3 = {{ 6, 4, 0, 0, 3, 0, 0, 0, 7 }, 
						 { 5, 0, 1, 0, 7, 0, 9, 0, 0 }, 
						 { 0, 0, 0, 0, 0, 0, 0, 1, 0 },
						 { 0, 0, 4, 9, 0, 8, 0, 6, 0 }, 
						 { 0, 8, 0, 0, 0, 3, 0, 2, 0 }, 
						 { 0, 0, 0, 4, 0, 0, 0, 0, 0 },
						 { 4, 0, 0, 1, 5, 7, 0, 3, 0 }, 
						 { 2, 0, 8, 3, 0, 0, 0, 4, 0 }, 
						 { 7, 5, 0, 0, 0, 0, 0, 9, 6 } };
		
		int[][] medium1 = {{ 0, 0, 0, 0, 0, 0, 6, 0, 9 }, 
						   { 1, 0, 0, 0, 0, 4, 0, 0, 0 }, 
						   { 0, 0, 5, 3, 0, 6, 8, 2, 1 },
						   { 0, 0, 4, 6, 7, 0, 0, 5, 0 }, 
						   { 0, 0, 7, 0, 0, 0, 9, 0, 0 }, 
						   { 0, 0, 0, 5, 4, 0, 0, 0, 0 },
						   { 3, 7, 0, 4, 0, 5, 2, 0, 6 }, 
						   { 0, 0, 0, 0, 0, 0, 5, 1, 0 }, 
						   { 0, 6, 0, 0, 2, 0, 0, 3, 7 } };
		
		
		int[][] medium2 ={{ 0, 0, 0, 4, 0, 0, 2, 0, 0 }, 
						{ 0, 0, 2, 0, 0, 0, 0, 1, 8 }, 
						{ 5, 0, 6, 9, 0, 0, 0, 3, 0 },
						{ 0, 6, 9, 0, 0, 0, 3, 0, 0 }, 
						{ 0, 5, 0, 0, 0, 0, 0, 2, 1 }, 
						{ 8, 0, 0, 1, 5, 7, 6, 0, 9 },
						{ 0, 0, 0, 0, 3, 0, 9, 6, 0 }, 
						{ 9, 0, 0, 6, 0, 2, 0, 5, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 7, 0, 2 } };
		
		int[][] expert1 = { { 0, 6, 0, 4, 0, 0, 0, 7, 0 }, 
							{ 0, 8, 0, 0, 0, 0, 0, 2, 9 }, 
							{ 0, 7, 0, 0, 2, 0, 5, 0, 0 },
							{ 0, 0, 5, 6, 0, 0, 0, 0, 4 }, 
							{ 9, 0, 0, 0, 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 5, 0, 0, 0, 0, 3 },
							{ 0, 0, 4, 1, 0, 0, 0, 0, 0 }, 
							{ 8, 0, 0, 0, 9, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 8, 0, 1, 0, 6 } };
		
		int[][] expert2 = { { 6, 0, 0, 3, 0, 0, 0, 0, 0 }, 
							{ 0, 1, 3, 0, 6, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 9, 0, 0, 8, 0 },
							{ 4, 0, 0, 0, 0, 5, 0, 0, 0 }, 
							{ 0, 6, 0, 0, 0, 4, 0, 9, 0 }, 
							{ 0, 3, 0, 0, 0, 0, 7, 0, 0 },
							{ 8, 0, 0, 0, 0, 0, 2, 5, 0 }, 
							{ 0, 0, 0, 8, 0, 1, 0, 0, 9 }, 
							{ 0, 4, 0, 9, 0, 0, 0, 0, 1 } };
		
		int[][] expert3 = { { 0, 0, 5, 0, 6, 0, 0, 3, 0 }, 
							{ 0, 0, 0, 1, 0, 0, 0, 0, 9 }, 
							{ 0, 2, 0, 3, 0, 0, 0, 5, 0 },
							{ 1, 0, 0, 0, 0, 0, 0, 0, 2 }, 
							{ 0, 0, 6, 0, 0, 8, 4, 0, 5 }, 
							{ 0, 0, 4, 0, 0, 0, 0, 1, 0 },
							{ 0, 7, 0, 0, 0, 0, 8, 0, 0 }, 
							{ 0, 0, 0, 0, 4, 9, 0, 0, 0 }, 
							{ 0, 0, 0, 8, 0, 7, 1, 0, 0 } };
		
		int[][] expert4 = { { 5, 0, 0, 9, 0, 0, 6, 0, 0 }, 
							{ 0, 0, 9, 2, 0, 0, 8, 3, 0 }, 
							{ 0, 0, 0, 0, 1, 0, 0, 4, 0 },
							{ 0, 9, 0, 0, 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0, 0, 6, 0, 8, 4 }, 
							{ 0, 1, 0, 0, 0, 0, 3, 0, 6 },
							{ 0, 6, 2, 0, 7, 0, 0, 0, 5 }, 
							{ 3, 0, 0, 5, 0, 0, 0, 2, 0 }, 
							{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		int[][] expert5 = { { 0, 0, 0, 0, 0, 0, 0, 5, 7 }, 
							{ 0, 0, 0, 0, 0, 6, 0, 0, 0 }, 
							{ 1, 0, 0, 7, 0, 0, 0, 9, 6 },
							{ 6, 0, 0, 0, 0, 0, 4, 0, 0 }, 
							{ 0, 0, 0, 0, 2, 0, 0, 0, 0 }, 
							{ 0, 4, 3, 0, 0, 0, 0, 0, 0 },
							{ 0, 0, 8, 0, 1, 0, 0, 0, 9 }, 
							{ 0, 9, 0, 2, 0, 7, 8, 0, 0 }, 
							{ 0, 0, 5, 0, 8, 4, 0, 7, 0 } };
		
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Zgjedhni njerin nga opsionet per veshtersine e sudokut:\n e(easy) m(medium) h(hard)");
	    String level = sc.nextLine(); 
	    if(level.equals("h")) {
			System.out.println("Zgjedhni njerin nga opsionet: 1 deri 5");
		    String op = sc.nextLine();
		    if(op.equals("1")) {
		    	startTime=System.currentTimeMillis();
		    	backtracking(expert1, 0, 0);}
		    else if(op.equals("2")){
		    	startTime=System.currentTimeMillis();
		    	backtracking(expert2, 0, 0);}
		    else if(op.equals("3")){
		    	startTime=System.currentTimeMillis();
		    	backtracking(expert3, 0, 0);}
		    else if(op.equals("4")){
		    	startTime=System.currentTimeMillis();
		    	backtracking(expert4, 0, 0);}
		    else if(op.equals("5")){
		    	startTime=System.currentTimeMillis();
		    	backtracking(expert5, 0, 0);}
		    else
		    	System.out.println("Nuk ishte nje opsion valid!");
	    }
	    else if(level.contentEquals("e")) {
	    	System.out.println("Zgjedhni njerin nga opsionet: 1 deri 3");
		    String op = sc.nextLine();
		    if(op.equals("1")) {
		    	startTime=System.currentTimeMillis();
		    	backtracking(easy1, 0, 0);}
		    else if(op.equals("2")){
		    	startTime=System.currentTimeMillis();
		    	backtracking(easy2, 0, 0);}
		    else if(op.equals("3")){
		    	startTime=System.currentTimeMillis();
		    	backtracking(easy3, 0, 0);}
	    else
	    	System.out.println("Nuk ishte nje opsion valid!");
    }
	    else if(level.contentEquals("m")) {
	    	System.out.println("Zgjedhni njerin nga opsionet: 1 deri 2");
		    String op = sc.nextLine();
		    if(op.equals("1")) {
		    	startTime=System.currentTimeMillis();
		    	backtracking(easy1, 0, 0);}
		    else if(op.equals("2")){
		    	startTime=System.currentTimeMillis();
		    	backtracking(easy2, 0, 0);}
		    else
		    	System.out.println("Nuk ishte nje opsion valid!");
    }	    
	    endTime=System.currentTimeMillis();
    	totalTime=endTime-startTime;
    	System.out.println("Zgjidhja perfundoi per: "+ totalTime+"ms");
    	
	}
	static long startTime=0,endTime=0,totalTime=0;
	
	public static void printSudoku(int[][] sudoku) {
		StringBuilder sb = new StringBuilder();
		for (int rreshti = 0; rreshti < 9; rreshti++) {
			for (int kolona = 0; kolona < 9; kolona++) {
				sb.append(sudoku[rreshti][kolona] + " ");
				if (kolona == 2 || kolona == 5)
					sb.append("| ");
			}
			if (rreshti == 2 || rreshti == 5)
				sb.append("\n ------------------- \n");
			else
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static Stack<Integer> stack = new Stack<Integer>();

	static void backtracking(int[][] sudoku, int rreshti, int kolona) {
		boolean test = false;
		while (rreshti < 9 && kolona < 9) {
			if (sudoku[rreshti][kolona] == 0)
				for (int i = 1; i <= 9; i++) {
					test = true;
					if (validoSudokun(sudoku, rreshti, kolona, i)) {
						sudoku[rreshti][kolona] = i;
						stack.push(kolona);
						stack.push(rreshti);
						backtracking(sudoku, rreshti, kolona);
					}
					sudoku[rreshti][kolona] = 0;
				}

			if (test) {
				rreshti = stack.pop();
				kolona = stack.pop();
				return;
			} else if (kolona == 8) {
				kolona = 0;
				rreshti++;
			} else
				kolona++;
		}
		if (kontrolloZgjidhjen(sudoku)) {
			printSudoku(sudoku);
		}
	}
	/*
	 * public static int[][] testque(int[][] sudoku, Stack<Integer> stack) { int
	 * rreshti = stack.pop(); int kolona = stack.pop();
	 * if(sudoku[rreshti][kolona]==9) { sudoku[rreshti][kolona]=0;
	 * System.out.println(stack); testque(sudoku,stack); } else
	 * sudoku[rreshti][kolona]=sudoku[rreshti][kolona]+1; return sudoku;
	 * 
	 * }
	 */

	public static boolean kontrolloZgjidhjen(int[][] sudoku) {
		boolean zgjidhja = true;

		for (int rreshti = 0; rreshti < 9; rreshti++)
			for (int kolona = 0; kolona < 9; kolona++)
				if (sudoku[rreshti][kolona] == 0)
					zgjidhja = false;

		return zgjidhja;
	}

	public static boolean validoSudokun(int[][] sudoku1, int pozitarr, int pozitak, int vlera) {
		int[][] sudoku = Arrays.stream(sudoku1).map(int[]::clone).toArray(int[][]::new);
		sudoku[pozitarr][pozitak] = vlera;

		// valido rreshtin
		for (int rreshti = 0; rreshti < 9; rreshti++) {
			for (int kolona = 0; kolona < 8; kolona++) {
				int pozita = sudoku[rreshti][kolona];
				for (int kolona1 = kolona; kolona1 < 8; kolona1++) {
					if (pozita == 0)
						continue;
					else {
						if (pozita == sudoku[rreshti][kolona1 + 1])
							return false;
					}
				}
			}
		}
		// valido kolonen
		for (int kolona = 0; kolona < 9; kolona++) {
			for (int rreshti = 0; rreshti < 8; rreshti++) {
				int pozita = sudoku[rreshti][kolona];
				for (int rreshti1 = rreshti; rreshti1 < 8; rreshti1++) {
					if (pozita == 0)
						continue;
					else {
						if (pozita == sudoku[rreshti1 + 1][kolona])
							return false;
					}
				}
			}
		}

		// valido katroret 3x3
		for (int rreshti = 0; rreshti < 9; rreshti += 3) {
			for (int kolona = 0; kolona < 9; kolona += 3) {
				for (int rreshti1 = rreshti; rreshti1 < rreshti + 3; rreshti1++) {
					for (int kolona1 = kolona; kolona1 < kolona + 3; kolona1++) {
						int pozita = sudoku[rreshti1][kolona1];
						if (pozita == 0)
							continue;
						else {
							if ((rreshti1 == 0 || rreshti1 == 3 || rreshti1 == 6)
									&& (kolona1 == 0 || kolona1 == 3 || kolona1 == 6))
								if (pozita == sudoku[rreshti1 + 1][kolona1 + 1]
										|| pozita == sudoku[rreshti1 + 1][kolona1 + 2]
										|| pozita == sudoku[rreshti1 + 2][kolona1 + 1]
										|| pozita == sudoku[rreshti1 + 2][kolona1 + 2])
									return false;
								else
									continue;
							else if ((rreshti1 == 0 || rreshti1 == 3 || rreshti1 == 6)
									&& (kolona1 == 1 || kolona1 == 4 || kolona1 == 7))
								if (pozita == sudoku[rreshti1 + 1][kolona1 - 1]
										|| pozita == sudoku[rreshti1 + 1][kolona1 + 1]
										|| pozita == sudoku[rreshti1 + 2][kolona1 - 1]
										|| pozita == sudoku[rreshti1 + 2][kolona1 + 1])
									return false;
								else
									continue;
							else if ((rreshti1 == 0 || rreshti1 == 3 || rreshti1 == 6)
									&& (kolona1 == 2 || kolona1 == 5 || kolona1 == 8))
								if (pozita == sudoku[rreshti1 + 1][kolona1 - 1]
										|| pozita == sudoku[rreshti1 + 1][kolona1 - 2]
										|| pozita == sudoku[rreshti1 + 2][kolona1 - 1]
										|| pozita == sudoku[rreshti1 + 2][kolona1 - 2])
									return false;
								else
									continue;
							else if ((rreshti1 == 1 || rreshti1 == 4 || rreshti1 == 7)
									&& (kolona1 == 0 || kolona1 == 3 || kolona1 == 6))
								if (pozita == sudoku[rreshti1 + 1][kolona1 + 1]
										|| pozita == sudoku[rreshti1 + 1][kolona1 + 2])
									return false;
								else
									continue;
							else if ((rreshti1 == 1 || rreshti1 == 4 || rreshti1 == 7)
									&& (kolona1 == 1 || kolona1 == 4 || kolona1 == 7))
								if (pozita == sudoku[rreshti1 + 1][kolona1 + 1]
										|| pozita == sudoku[rreshti1 + 1][kolona1 - 1])
									return false;
								else
									continue;
							else if ((rreshti1 == 1 || rreshti1 == 4 || rreshti1 == 7)
									&& (kolona1 == 2 || kolona1 == 5 || kolona1 == 8))
								if (pozita == sudoku[rreshti1 + 1][kolona1 - 1]
										|| pozita == sudoku[rreshti1 + 1][kolona1 - 2])
									return false;
								else
									continue;

						}
					}
				}
			}
		}
		return true;

	}

}