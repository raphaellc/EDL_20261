# EDL_20261
Repositório de Códigos de Estrutura de Dados Lineares - 2026/1
# 🚀 Disciplina: Estrutura de Dados Lineares
## Curso: Análise e Desenvolvimento de Sistemas (ADS)

Este repositório centraliza as atividades práticas da disciplina. Utilizaremos um fluxo de trabalho profissional baseado em **Pull Requests** e **Integração Contínua (CI)** para automatizar a validação das entregas.

---

## 📂 1. Organização de Diretórios

Para que o corretor automático identifique sua entrega, a estrutura de pastas deve seguir rigorosamente este padrão:

### Entregas Individuais
Devem estar dentro de uma pasta com seu **Nome Completo** (substitua espaços por hífen e evite acentos).
* `Nome-Completo/exercicio1/`
* `Nome-Completo/exercicio2/`

### Trabalhos em Grupo
Devem ser colocados em uma pasta específica na **raiz do repositório**.
* `/Trabalho-Grupo-01/`
* `/Projeto-Final/`

---

## 🌿 2. Fluxo de Trabalho (GitFlow)

Siga estes passos para cada nova atividade:

1.  **Sincronize seu repositório local:**
    ```bash
    git checkout entrega
    git pull origin entrega
    ```
2.  **Crie uma branch para sua tarefa:**
    * *Individual:* `git checkout -b feature/nome-aluno-ex1`
    * *Grupo:* `git checkout -b feature/nome-do-grupo`
3.  **Desenvolva e Commite:** Certifique-se de que seu código compila localmente.
4.  **Envie para o GitHub:**
    ```bash
    git push origin sua-branch-de-entrega
    ```
5.  **Abra um Pull Request (PR):** No GitHub, solicite o merge da sua branch para a branch **`entrega`**.

---

## ✅ 3. Regras de Ouro e Automação

* **Compilação Obrigatória:** Ao abrir um PR, o **GitHub Actions** tentará compilar seu código Java automaticamente. 
    * ✅ **Verde:** O código compila. O professor fará a revisão lógica.
    * ❌ **Vermelho:** O código falhou. **A entrega não será avaliada** até que você corrija os erros e faça o push novamente no mesmo PR.
* **Acesso e Permissões:** * A branch `entrega` é protegida. Pushes diretos serão rejeitados.
    * Apenas o **Professor (Admin)** tem permissão para aprovar e finalizar o Merge dos PRs.
* **Ética e Colaboração:** Embora todos sejam colaboradores, é expressamente proibido alterar arquivos em