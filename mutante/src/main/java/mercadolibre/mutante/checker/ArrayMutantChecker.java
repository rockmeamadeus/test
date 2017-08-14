package mercadolibre.mutante.checker;

public class ArrayMutantChecker implements IMutantChecker {

	@Override
	public boolean isMutant(String[] dna) {

		int matches = 0;

		for (String word : words) {

			if (patternSearch(dna, word) && ++matches > 1) {
				return true;
			}

		}

		return false;
	}

	// For searching in all 8 direction
	private static int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// This function searches in all 8-direction from point
	// (row, col) in grid[][]
	private boolean search2D(String grid[], int row, int col, String word) {

		// If first character of word doesn't match with
		// given starting point in grid.
		if (grid[row].charAt(col) != word.charAt(0))
			return false;

		int len = word.length();

		// Search word in all 8 directions starting from (row,col)
		for (int dir = 0; dir < 8; dir++) {
			// Initialize starting point for current direction
			int k, rd = row + x[dir], cd = col + y[dir];

			// First character is already checked, match remaining
			// characters
			for (k = 1; k < len; k++) {
				// If out of bound break
				if (rd >= grid.length || rd < 0 || cd >= grid.length || cd < 0)
					break;

				// If not matched, break
				if (grid[rd].charAt(cd) != word.charAt(k))
					break;

				// Moving in particular direction
				rd += x[dir];
				cd += y[dir];
			}

			// If all character matched, then value of must
			// be equal to length of word
			if (k == len)
				return true;
		}
		return false;
	}

	// Searches given word in a given matrix in all 8 directions
	private boolean patternSearch(String dna[], String word) {
		// Consider every point as starting point and search
		// given word
		for (int row = 0; row < dna.length; row++)
			for (int col = 0; col < dna.length; col++)
				if (search2D(dna, row, col, word)) {
					System.out.println("pattern found at " + row + " " + col);
					System.out.println(dna[row].charAt(col));
					System.out.println(word);
					return true;
				}


		return false;

	}

}
