package Lista;

import java.util.Objects;

public class Objeto<Classe>{
    private Classe objeto;
    private Objeto proximo;
    private Objeto anterior;

    public Objeto(Classe objeto) {
        this.objeto = objeto;
    }

    public Classe getObjeto() {
        return objeto;
    }

    public void setObjeto(Classe objeto) {
        this.objeto = objeto;
    }

    public Objeto getProximo() {
        return proximo;
    }

    public void setProximo(Objeto proximo) {
        this.proximo = proximo;
    }

    public Objeto getAnterior() {
        return anterior;
    }

    public void setAnterior(Objeto anterior) { this.anterior = anterior; }

    public boolean equalsObjeto(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objeto<?> objeto1 = (Objeto<?>) o;
        return Objects.equals(objeto, objeto1.objeto);
    }
}