
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKOKO = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(OLETUSKOKO, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Taulukon koko tai määrä, jolla sitä kasvatetaan, ei saa olla negatiivinen.");
        }
        joukko = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (lukuLoytyyTaulukosta(luku)) {
            return false;
        }
        joukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm == joukko.length) {
            int[] uusiTaulukko = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(joukko, uusiTaulukko);
            joukko = uusiTaulukko;
        }
        return true;
    }

    public boolean lukuLoytyyTaulukosta(int luku) {
        boolean loytyy = false;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                loytyy = true;
            }
        }
        return loytyy;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = etsiPoistettavanIndeksi(luku);
        if (poistettavanIndeksi != -1) {
            siirraArvoja(poistettavanIndeksi);
            return true;
        }
        return false;
    }
    
    private int etsiPoistettavanIndeksi(int luku) {
        int poistettavanIndeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                poistettavanIndeksi = i;
                break;
            }
        }
        return poistettavanIndeksi;
    }
    
    private void siirraArvoja(int poistetunIndeksi) {
        int viimeisenArvonIndeksi = alkioidenLkm - 1;
        for (int j = poistetunIndeksi; j < viimeisenArvonIndeksi; j++) {
            joukko[j] = joukko[j + 1];
        }
        joukko[viimeisenArvonIndeksi] = 0;
        alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                sb.append(joukko[i] + ", ");
            }
            sb.append(joukko[alkioidenLkm - 1]);
            sb.append("}");
            return sb.toString();
        }
    }

    public int[] getJoukko() {
        int[] palautettavaJoukko = new int[alkioidenLkm];
        for (int i = 0; i < alkioidenLkm; i++) {
            palautettavaJoukko[i] = joukko[i];
        }
        return palautettavaJoukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.getJoukko();
        int[] bTaulu = b.getJoukko();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.getJoukko();
        int[] bTaulu = b.getJoukko();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.getJoukko();
        int[] bTaulu = b.getJoukko();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
        return z;
    }     
}