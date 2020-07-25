import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ForwardCheckingwDO {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean tmp = true;

		SudokuExamples sd = new SudokuExamples();
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Choose sudoku difficulty:\n e(easy) m(medium) h(hard)");
	    String level = sc.nextLine(); 
	    if(level.equals("h")) {
			System.out.println("Choose from 1 to 5:");
		    String op = sc.nextLine();
		    if(op.equals("1")) {
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.hard1, 0, 0);}
		    else if(op.equals("2")){
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.hard2, 0, 0);}
		    else if(op.equals("3")){
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.hard3, 0, 0);}
		    else if(op.equals("4")){
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.hard4, 0, 0);}
		    else if(op.equals("5")){
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.hard5, 0, 0);}
		    else{
				System.out.println("Input wasn't valid!");
	    		tmp = false;
				}
			}
	    else if(level.contentEquals("e")) {
	    	System.out.println("Choose from 1 to 3:");
		    String op = sc.nextLine();
		    if(op.equals("1")) {
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.easy1, 0, 0);}
		    else if(op.equals("2")){
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.easy2, 0, 0);}
		    else if(op.equals("3")){
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.easy3, 0, 0);}
	    else{
			System.out.println("Input wasn't valid!");
	    	tmp = false;
			}
	    }
	    else if(level.contentEquals("m")) {
	    	System.out.println("Choose 1 or 2:");
		    String op = sc.nextLine();
		    if(op.equals("1")) {
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.medium1, 0, 0);}
		    else if(op.equals("2")){
		    	startTime=System.currentTimeMillis();
		    	forwardChecking(sd.medium2, 0, 0);}
		    else{
				System.out.println("Input wasn't valid!");
	    		tmp = false;
				} 
		}
		else {
			System.out.println("Input wasn't valid!");
	    	tmp = false;
		}
		if(tmp){	    
	    endTime=System.currentTimeMillis();
    	totalTime=endTime-startTime;
    	System.out.println("Solution was completed in "+ totalTime+"ms");
		}

	}
	static long startTime=0,endTime=0,totalTime=0;

public static ArrayList<Integer> findValidMoves(int[][] sudoku, int row, int col) {
	ArrayList<Integer> validMoves = new ArrayList<Integer>();
			for (int k = 1; k <= 9; k++) { 
				if (validSudoku(sudoku, row, col, k)) {
					validMoves.add(k);
				}
			}
			return validMoves;
			
}

public static ArrayList<Integer> findMin(int[][] sudoku){
	  int row=0,col=0;
      int min=9;
      int tmp;
      ArrayList<Integer> rrk = new ArrayList<Integer>();
      for (int k = 0; k < 9; k++) {
          for (int l = 0; l < 9; l++) {
              if(sudoku[k][l]==0){
                  tmp=findValidMoves(sudoku, k, l).size();
                  if(tmp < min){
                      min=tmp;
                      row=k;col=l;
                  }
              }
          }
      }
      rrk.add(row);
      rrk.add(col);
	return rrk;
	
}

static Stack<Integer> stack = new Stack<Integer>();

static void forwardChecking(int[][] sudoku, int row, int col) {
	boolean test = false;
	ArrayList<Integer> rrk = new ArrayList<Integer>();
	while (row < 9 && col < 9) {
		if (sudoku[row][col] == 0) {
				test = true;
				rrk = findMin(sudoku);
				row = rrk.get(0);
				col = rrk.get(1);
				for(int k : findValidMoves(sudoku,row,col)){
					sudoku[row][col] = k;
					stack.push(col);
					stack.push(row);
					forwardChecking(sudoku, 0, 0);
					}
					sudoku[row][col]=0;
			}
		if (test) {
			row = stack.pop();
			col = stack.pop();
			return;}
		else if (col == 8) {
			col = 0;
			row++;
		} else
			col++;
	}
	if (solution(sudoku)) {
		printsudoku(sudoku);
	}
}
public static boolean solution(int[][] sudoku) {
	boolean solution = true;

	for (int row = 0; row < 9; row++)
		for (int col = 0; col < 9; col++)
			if (sudoku[row][col] == 0)
				solution = false;

	return solution;
}
public static void printsudoku(int[][] sudoku) {
	
StringBuilder sb = new StringBuilder();
for (int row = 0; row < 9; row++) {
	for (int col = 0; col < 9; col++) {
		sb.append(sudoku[row][col] + " ");
		if (col == 2 || col == 5)
			sb.append("| ");
	}
	if (row == 2 || row == 5)
		sb.append("\n ------------------- \n");
	else
		sb.append("\n");
}
System.out.println(sb.toString());

}
	public static boolean validSudoku(int[][] sudoku1, int posrow, int poscol, int value) {
		int[][] sudoku = Arrays.stream(sudoku1).map(int[]::clone).toArray(int[][]::new);
		sudoku[posrow][poscol] = value;

		// row
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 8; col++) {
				int pos = sudoku[row][col];
				for (int col1 = col; col1 < 8; col1++) {
					if (pos == 0)
						continue;
					else {
						if (pos == sudoku[row][col1 + 1])
							return false;
					}
				}
			}
		}
		// column
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 8; row++) {
				int pos = sudoku[row][col];
				for (int row1 = row; row1 < 8; row1++) {
					if (pos == 0)
						continue;
					else {
						if (pos == sudoku[row1 + 1][col])
							return false;
					}
				}
			}
		}

		// squares 3x3
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				for (int row1 = row; row1 < row + 3; row1++) {
					for (int col1 = col; col1 < col + 3; col1++) {
						int pos = sudoku[row1][col1];
						if (pos == 0)
							continue;
						else {
							if ((row1 == 0 || row1 == 3 || row1 == 6)
									&& (col1 == 0 || col1 == 3 || col1 == 6))
								if (pos == sudoku[row1 + 1][col1 + 1]
										|| pos == sudoku[row1 + 1][col1 + 2]
										|| pos == sudoku[row1 + 2][col1 + 1]
										|| pos == sudoku[row1 + 2][col1 + 2])
									return false;
								else
									continue;
							else if ((row1 == 0 || row1 == 3 || row1 == 6)
									&& (col1 == 1 || col1 == 4 || col1 == 7))
								if (pos == sudoku[row1 + 1][col1 - 1]
										|| pos == sudoku[row1 + 1][col1 + 1]
										|| pos == sudoku[row1 + 2][col1 - 1]
										|| pos == sudoku[row1 + 2][col1 + 1])
									return false;
								else
									continue;
							else if ((row1 == 0 || row1 == 3 || row1 == 6)
									&& (col1 == 2 || col1 == 5 || col1 == 8))
								if (pos == sudoku[row1 + 1][col1 - 1]
										|| pos == sudoku[row1 + 1][col1 - 2]
										|| pos == sudoku[row1 + 2][col1 - 1]
										|| pos == sudoku[row1 + 2][col1 - 2])
									return false;
								else
									continue;
							else if ((row1 == 1 || row1 == 4 || row1 == 7)
									&& (col1 == 0 || col1 == 3 || col1 == 6))
								if (pos == sudoku[row1 + 1][col1 + 1]
										|| pos == sudoku[row1 + 1][col1 + 2])
									return false;
								else
									continue;
							else if ((row1 == 1 || row1 == 4 || row1 == 7)
									&& (col1 == 1 || col1 == 4 || col1 == 7))
								if (pos == sudoku[row1 + 1][col1 + 1]
										|| pos == sudoku[row1 + 1][col1 - 1])
									return false;
								else
									continue;
							else if ((row1 == 1 || row1 == 4 || row1 == 7)
									&& (col1 == 2 || col1 == 5 || col1 == 8))
								if (pos == sudoku[row1 + 1][col1 - 1]
										|| pos == sudoku[row1 + 1][col1 - 2])
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
