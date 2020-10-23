package wa;

public class PrefixAverage1 {
  public static void main(String[] args) {
      System.out.println("Hello World!");
  }

  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];
    for (int i = 0; i < n; i++) {
      double total = 0;
      for (int j = 0; j <= i; j++) {
        total += x[j];
      }
      a[i] = total / (i + 1);
    }
    return a;
  }
}
