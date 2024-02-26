enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Aluno(
    val nome: String,
    val email: String,
    val dataNascimento: String
)

data class ConteudoEducacional(    
    var nome: String,
    var duracao: Int = 60,
    var descricao: String,
    var nivelDificuldade: Nivel,
    var categoria: String)	{
    
    fun atualizarConteudo(novoNome: String, novaDuracao: Int, novaDescricao: String, novaDificuldade: Nivel, novaCategoria: String) {
        nome = novoNome
        duracao = novaDuracao
        descricao = novaDescricao
        nivelDificuldade = novaDificuldade
        categoria = novaCategoria
    }
}
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    
    val formacoes = mutableListOf<Formacao>()
    
    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
    }
    
    fun desmatricular(aluno: Aluno) {
        inscritos.remove(aluno)
    }
 
 	fun imprimirInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEachIndexed { index, aluno ->
            println("${index + 1}. Nome: ${aluno.nome}, Email: ${aluno.email}, Data de Nascimento: ${aluno.dataNascimento}")
        }
	}
    
    fun casdastrarFormacao(formacao: Formacao){
        formacoes.add(formacao)
    }
    
    fun removerFormacao(formacao: Formacao){
        formacoes.remove(formacao)
    }
    
    fun imprimirConteudos(){
        println("Conteúdos disponíveis na formação $nome:")
        conteudos.forEachIndexed { index, conteudos ->
            println("${index + 1}. Nome: ${conteudos.nome}, Duração: ${conteudos.duracao}, Descrição: ${conteudos.descricao}, Nível de Dificuldade: ${conteudos.nivelDificuldade}")
        }
        
    }
}

fun main() {
    
    val aluno1 = Aluno("Alice", "alice@example.com", "12/03/1990")
    val aluno2 = Aluno("Bob", "bob@example.com", "30/10/1991")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90, "Conteúdo introdutório sobre programação", Nivel.BASICO, "Programação")
    val conteudo2 = ConteudoEducacional("Algoritmos e Estruturas de Dados", 120, "Estudo de algoritmos e estruturas de dados", Nivel.INTERMEDIARIO, "Programação")
    val conteudo3 = ConteudoEducacional("Algoritmo", 360, "Estudo avançado de algoritmos", Nivel.DIFICIL, "Programação")

    val formacao1 = Formacao("Desenvolvimento de Software com Kotlin", listOf(conteudo1, conteudo2))
    
    val formacao2 = Formacao("Algoritmo Avançado", listOf(conteudo3))
	
    
    formacao1.matricular(aluno1)
    formacao1.matricular(aluno2)
   
    formacao1.imprimirInscritos()
    println()
    
    formacao1.desmatricular(aluno2)
    
    val aluno3 = Aluno("Lucas", "lucas@example.com", "20/5/1992")
    formacao1.matricular(aluno3)
    formacao2.matricular(aluno2)
    
    formacao1.imprimirInscritos()
    println()
    formacao2.imprimirInscritos()
    println()
    formacao1.imprimirConteudos()
    
    
    
}