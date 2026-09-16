# Plataforma de Mensagens — Fatura por Canal

Sistema em Java que calcula a fatura mensal de uma plataforma de mensagens,
somando envios de canais diferentes (E-mail e SMS) com regras de preço
distintas. Trabalho da disciplina de Programação Orientada a Objetos.

## O problema

Empresas como bancos e lojas virtuais não enviam e-mail e SMS por conta
própria — elas contratam uma plataforma e pagam por envio realizado. Cada
canal cobra de um jeito, mas tudo precisa ser somado numa fatura única no
fim do mês.

Esse é exatamente o tipo de problema que **herança e polimorfismo** resolvem:
o código percorre uma lista de mensagens sem precisar saber qual é o tipo
de cada uma. O Java decide sozinho qual versão do cálculo chamar.

## Regras de preço

| Canal   | Preço por envio | Regra adicional                                   |
|---------|-----------------|---------------------------------------------------|
| E-mail  | R$ 0,02         | Acima de 1000 envios, aplica 10% de desconto      |
| SMS     | R$ 0,15         | Sem desconto                                      |

## Arquitetura

- `Mensagem` — classe mãe, guarda `campanha` e `quantidade`, define o
  contrato de `calcularCusto()`, `getCanal()` e o método `void`
  `exibirResumo()`.
- `Email extends Mensagem` — sobrescreve o cálculo com a regra de desconto.
- `SMS extends Mensagem` — sobrescreve o cálculo com preço fixo.
- `Main` — monta um vetor `Mensagem[]`, percorre chamando `exibirResumo()`,
  soma os custos e valida o limite da fatura.

O vetor é do tipo `Mensagem[]` mesmo guardando objetos `Email` e `SMS`.
Nenhum `if` verifica o tipo do objeto — o polimorfismo cuida disso.

## Conceitos aplicados

- Herança (`extends`, `super`)
- Polimorfismo em tempo de execução
- Sobrescrita de métodos (`@Override`)
- Encapsulamento via `protected`
- Separação entre métodos com retorno e métodos `void`
- Formatação de saída com `System.out.printf`

## Como rodar

```bash
javac Main.java
java Main