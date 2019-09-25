
/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
	int[] tirs;
	int tiractuel;

	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            tirs=new int[21];
            
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
					tirs[tiractuel++] = nombreDeQuillesAbattues;   
            }

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
			int score = 0;
			int tir = 0;

			for (int i = 0; i < 10; i++) {
				if (Strike(tir)) {
					score += 10 + strikechaine(tir);
					tir++;
				} else if (Spare(tir)) {
					score += 10 + sparechaine(tir);
					tir+= 2;
				} else {
					score += tirs[tir] + tirs[tir+1];
					tir += 2;
				}
			}

			return score;
		}
	public boolean Strike(int tir) {
		return tirs[tir] == 10;
	}

	public boolean Spare(int tir) {
		return tirs[tir] + tirs[tir+1] == 10;
	}

	public int strikechaine(int tir) {
		return tirs[tir+1] + tirs[tir+2];
	}

	public int sparechaine(int tir) {
		return tirs[tir+2];
	}
}