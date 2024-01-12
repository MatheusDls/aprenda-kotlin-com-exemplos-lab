enum class Nivel { INICIANTE, INTERMEDIARIO, AVANÇADO }

class Usuario(val nome: String, val id: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(var nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel = Nivel.INICIANTE) {

    val inscritos = mutableListOf<Usuario>()
    
    //fun matricular(usuario: Usuario) {
       // TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        fun matricular(vararg usuario: Usuario){
            for (user in usuario){
                if(user in inscritos){
                    println("Usuários: ${user.nome} já cadastrado!")
                } else{
                    inscritos.add(user)
                }
            
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    val usuario = Usuario("Gustavo", 10)
    val usuario2 = Usuario("Mike", 11)
    val usuario3 = Usuario("Jack", 12)
    val usuario4 = Usuario("nick", 13)
    
    val conteudoAula = ConteudoEducacional("Introdução a Kotlin", 20)
    val conteudoAula1 = ConteudoEducacional("Back_end com Kotlin", 40)
    
    var curso1 = Formacao ("Dev Kotlin", listOf(conteudoAula), Nivel.INICIANTE) 
    var curso2 = Formacao ("Back_End", listOf(conteudoAula, conteudoAula1), Nivel.INTERMEDIARIO)
    
    curso1.matricular(usuario, usuario2)
    curso2.matricular(usuario3,usuario4)
    
    println("\nInscritos no Curso: ${curso1.nome}")
    for (inscrito in curso1.inscritos){
        println("Nome: ${inscrito.nome}. Id: ${inscrito.id}")
    }

    println("\nInscritos no Curso: ${curso2.nome}")
    for (inscrito in curso2.inscritos){
        println("Nome: ${inscrito.nome}. Idade: ${inscrito.id}")
    }
        
}