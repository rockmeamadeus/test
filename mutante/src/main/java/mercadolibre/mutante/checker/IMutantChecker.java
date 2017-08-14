package mercadolibre.mutante.checker;

public interface IMutantChecker {

	String[] words = { "AAAA", "TTTT", "CCCC", "GGGG" };

	public boolean isMutant(String[] dna) throws Exception;

}
