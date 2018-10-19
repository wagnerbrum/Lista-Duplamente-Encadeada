package Lista;
public class Lista<Classe>{
    Objeto<Classe> primeiro, ultimo;
    int quantidade;

    public Lista() {
        this.limpar();
    }

    public void addAux(Classe objeto) {
        Objeto<Classe> obj = new Objeto(objeto);
        primeiro = ultimo = obj;
    }

    public boolean addInicio(Classe objeto) {
        if(objeto == null) {
            return false;
        }
        if(this.quantidade == 0) {
            addAux(objeto);
            quantidade++;
        } else {
            Objeto<Classe> obj = new Objeto(objeto);
            this.primeiro.setAnterior(obj);
            obj.setProximo(this.primeiro);
            this.primeiro = obj;
            quantidade++;
        }
        return true;
    }

    public boolean addFim(Classe objeto) {
        if(objeto == null) {
            return false;
        }
        if(this.quantidade == 0) {
            addAux(objeto);
            quantidade++;
        } else {
            Objeto<Classe> obj = new Objeto(objeto);
            this.ultimo.setProximo(obj);
            obj.setAnterior(this.ultimo);
            this.ultimo = obj;
            quantidade++;
        }
        return true;
    }

    public boolean addPosicao(Classe objeto, int posicao){
        if(objeto == null || posicao < 0 || posicao > (this.quantidade+1)){
            return false;
        }
        if(posicao == 0) {
            addInicio(objeto);
        }else if(posicao == this.quantidade) {
            addFim(objeto);
        }else{
            int meio = (int) Math.round((double) posicao/2);
            Objeto<Classe> aux;
            Objeto<Classe> obj = new Objeto(objeto);

            if(posicao <= meio){
                aux = this.primeiro;
                for(int i = 0; i < posicao; i++){
                    aux = aux.getProximo();
                }
            }else{
                aux = this.ultimo;
                for(int i = this.quantidade; i > posicao; i--){
                    aux = aux.getAnterior();
                }
            }
            obj.setAnterior(aux.getAnterior());
            obj.setProximo(aux);
            obj.getAnterior().setProximo(obj);
            aux.setAnterior(obj);
            this.quantidade++;
        }

        return true;
    }

    public boolean removeInicio(){
        if(quantidade == 0){
            return false;
        }
        if(quantidade == 1){
            this.primeiro = this.ultimo = null;
        }else if(quantidade > 1){
            this.primeiro = this.primeiro.getProximo();
            this.primeiro.setAnterior(null);
        }
        quantidade--;
        return true;
    }

    public boolean removeFim(){
        if(quantidade == 0){
            return false;
        }
        if(quantidade == 1){
            this.primeiro = this.ultimo = null;
        }else if(quantidade > 1){
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setProximo(null);
        }
        quantidade--;
        return true;
    }

    public boolean removePosicao(int posicao){
        if(quantidade == 0 || posicao >= quantidade || posicao < 0){
            return false;
        }
        if(quantidade == 1){
            this.primeiro = this.ultimo = null;
        }else if(quantidade > 1){

            if(posicao == 0){
                this.removeInicio();
                return true;
            }else if(posicao == quantidade-1){
                this.removeFim();
                return true;
            }

            int meio = (int) Math.round((double) posicao/2);
            Objeto<Classe> aux;

            if(posicao <= meio){
                aux = this.primeiro;
                for(int i = 0; i < posicao; i++){
                    aux = aux.getProximo();
                }
            }else{
                aux = this.ultimo;
                for(int i = this.quantidade-1; i > posicao; i--){
                    aux = aux.getAnterior();
                }
            }

            aux.getProximo().setAnterior(aux.getAnterior());
            aux.getAnterior().setProximo(aux.getProximo());
            quantidade--;
            return true;
        }
        return false;
    }

    public Classe buscarPorPosicao(int posicao){
        if(posicao < 0 || posicao >= quantidade){
            return null;
        }

        if(posicao == 0){
            return this.primeiro.getObjeto();
        }else if(posicao == this.quantidade-1){
            return this.ultimo.getObjeto();
        }else{
            Objeto<Classe> aux = primeiro;

            for(int i = 0; i < posicao; i++){
                aux = aux.getProximo();
            }

            return aux.getObjeto();
        }
    }

    public void limpar(){
        primeiro = ultimo = null;
        this.quantidade = 0;
    }

    public int tamanho() {
        return quantidade;
    }

    public int indexOf(Classe classe){
        if(classe == null){
            return -1;
        }

        if(classe.equals(primeiro.getObjeto())){
            return 0;
        }else if(classe.equals(ultimo.getObjeto())){
            return quantidade-1;
        }else{
            Objeto<Classe> aux, aux1;
            aux = aux1 = primeiro;
            for(int i = 0; i < quantidade-1; i++){
                aux1 = aux;
                aux = aux.getProximo();

                if(classe.equals(aux.getObjeto())){
                    return i+1;
                }
            }
        }

        return -1;
    }

    public boolean contem(Classe classe){
        int teste = indexOf(classe);

        if(teste == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean vazio(){
        if(quantidade == 0){
            return true;
        }else{
            return false;
        }
    }

    public void imprimirTodos() {
        Objeto<Classe> aux = primeiro;
        for(int i = 0; i < quantidade; i++){
            System.out.println("\nObjeto atual => "+aux+" , Nome => "+aux.getObjeto().toString());
            System.out.println("Anterior => "+aux.getAnterior());
            System.out.println("Proximo => "+aux.getProximo());
            aux = aux.getProximo();
        }
    }
}
