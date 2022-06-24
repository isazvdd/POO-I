public class SerieLucas{
    final int p,q;
    int n;
    
    public SerieLucas(int p, int q)
    {
        this.p = p;
        this.q = q;
        this.n = -1;
    }
    
    public int proximo(){
        n++;
        return serie(n);
    }
    
    public int pular(int quantidade){
        n += quantidade;
        return serie(n);
    }
    
    private int serie(int n){
        if(n<2) {
            return n;
        }
        return p*serie(n-1) - q*serie(n-2);
    }
}
