package src.vendedor.entidade;

public class Vendedor {

    private String nome;
    private static Double salarioInicial = 1.500;
    private Integer tempoDeServico;
    private char categoria;
    private Double totalVendas;

    public Vendedor(String nome, Integer tempoDeServico, Double totalVendas) {
        this.nome = nome;
        this.tempoDeServico = tempoDeServico;
        this.totalVendas = totalVendas;

        if (tempoDeServico > 60) {
            this.categoria = 'A';
        } else if (tempoDeServico < 30) {
            this.categoria = 'C';
        } else {
            this.categoria = 'B';
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Double getSalarioInicial() {
        return salarioInicial;
    }

    public static void setSalarioInicial(Double salarioInicial) {
        Vendedor.salarioInicial = salarioInicial;
    }

    public Integer getTempoDeServico() {
        return tempoDeServico;
    }

    public void setTempoDeServico(Integer tempoDeServico) {
        this.tempoDeServico = tempoDeServico;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public Double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Double totalVendas) {
        this.totalVendas = totalVendas;
    }

    @Override
    public String toString() {
        return String.format("""
        Nome: %s
        Tempo de Serviço: %d horas
        Categoria: %c
        Total de Vendas: R$ %.2f
        Comissão: R$ %.2f
        Gratificação: R$ %.2f
        Salário Final: R$ %.2f
        """,
                nome, tempoDeServico, categoria, totalVendas, comissao(), gratificao(), salario());
    }

//    comissao que calcula e retorna a comissão do vendedor de acordo com o valor de suas vendas: 20% do total de sua venda,
//    se ela ultrapassou R$ 20.000,00, 15% se ela esteve entre R$ 10.000,00 e R$ 20.000,00 inclusive e 5% se suas vendas não
//    chegaram a R$10.000,00.

    public double comissao() {
        if (this.totalVendas > 20000) {
            return this.totalVendas * 0.2;
        }
        else if (this.totalVendas < 10000) {
            return this.totalVendas * 0.05;
        }
        else {
            return this.totalVendas * 0.15;
        }
    }

//    gratificacao que calcula e retorna a gratificação do vendedor de acordo com sua categoria:  15% do salário base para
//    Categoria ‘A’ e 7,5% para Categoria ‘B’.

    public double gratificao() {
        if (this.categoria == 'A') {
            return this.salarioInicial * 0.15;
        }
        else if (this.categoria == 'B') {
            return this.salarioInicial * 0.075;
        }
        else {
            return 0;
        }
    }

//    salario que calcula e retorna o salário do vendedor que é o seu salário base mais sua comissão mais sua gratificação.

    public double salario() {
        return this.salarioInicial + comissao() + gratificao();
    }
}
