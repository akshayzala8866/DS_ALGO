public class Search_Word_In_Marix {

	public static int xMove[] = {0, 0, -1, 1, -1, -1, 1, 1};
	public static int yMove[] = {1, -1, 0, 0, -1, 1, -1, 1};
	public static   char mArray[][] = {{'G','E','E','K','S','F','O','R','G','E','E','K','S'}, 
                                {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'}, 
                                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}}; 
          
    public static boolean isSearch(String str, int x, int y, char mArray[][]) {
    	int xNext, yNext;

    	if (mArray[x][y] != str.charAt(0)) {
    		return false;
    	}

    	for (int i = 0; i < xMove.length; i++) {
    		int j;
    		xNext = x + xMove[i];
    		yNext = y + yMove[i];

    		for (j = 1; j < str.length(); j++) {
    			if (xNext < 0 || yNext < 0 || yNext >= mArray[0].length || xNext >= mArray.length) {
    				break;
    			}

    			if (mArray[xNext][yNext] != str.charAt(j)) {
    				break;
    			}

    			xNext += xMove[i];
    			yNext += yMove[i];
    		}

    		if (j == str.length()) {
    			return true;
    		}
    	}

    	return false;
    }

    public static void FindWord(String str, char mArray[][]) {
    	for (int i = 0; i < mArray.length; i++) {
    		for (int j = 0; j < mArray[0].length; j++) {
    			if (isSearch(str, i, j, mArray)) {
    				System.out.println(i + " : " + j);
    			}
    		}
    	}
    }

	public static void main(String[] args) {

		String str = "GEEKS";

		FindWord(str, mArray);
	}
}
