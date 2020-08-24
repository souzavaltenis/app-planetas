package com.example.collapsingtest;

import java.util.ArrayList;
import java.util.List;

public class Planeta {

    private String nome;
    private String descricao;
    private int img;

    public Planeta(String nome, String descricao, int img) {
        this.nome = nome;
        this.descricao = descricao;
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public static List<Planeta> getPlanetas() {

        List<Planeta> planetas = new ArrayList<>();

        planetas.add(new Planeta("Mercúrio", "Mercúrio, menor planeta do sistema " +
                "solar, como também o mais próximo do sol. Suas temperaturas chegam a 400°C.",
                R.drawable.mercurio));

        planetas.add(new Planeta("Vênus", "Vênus, também chamado de “Estrela " +
                "D’Alva”, não possui satélite. Ele é o segundo planeta a partir do sol e o mais " +
                "perto do planeta Terra.", R.drawable.venus));

        planetas.add(new Planeta("Terra", "Terra, terceiro planeta do sistema " +
                "solar a partir do Sol, é rochoso, com atmosfera gasosa e temperatura " +
                "média de 15°C.", R.drawable.terra));

        planetas.add(new Planeta("Marte", "Marte, quarto planeta a partir do" +
                " sol, possui dois satélites naturais \"Fobos e Deimos”, sendo o segundo menor " +
                "planeta do sistema solar.", R.drawable.marte));

        planetas.add(new Planeta("Júpiter", "Júpiter, quinto planeta a partir do " +
                "sol, possui o maior número de satélites, 67, e apresenta temperaturas de até" +
                " -150°C.", R.drawable.jupiter));

        planetas.add(new Planeta("Saturno", "Saturno, segundo maior planeta do " +
                "sistema solar, ele é conhecido pelos seus anéis, formados por rocha, gelo e" +
                " poeira. Sexto planeta a partir do sol, possui 62 luas.", R.drawable.saturno));

        planetas.add(new Planeta("Urano", "Urano, terceiro maior planeta do " +
                "sistema solar e sétimo planeta a partir do sol, ele é gasoso que apresenta " +
                "médias de temperatura de -185°C e possui 27 satélites.", R.drawable.urano));

        planetas.add(new Planeta("Netuno", "Netuno, é o mais distante do sol e o " +
                "quarto maior em tamanho, possui 14 satélites naturais e apresenta temperaturas " +
                "médias de aproximadamente -200°C.", R.drawable.netuno));

        return planetas;
    }
}
