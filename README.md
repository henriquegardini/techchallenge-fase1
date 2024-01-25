## techchallenge-fase1 - Turma 3ADJT - Grupo 9

### Contexto
O contexto do negócio está focado no controle de acesso de visitantes em um condomínio. Atualmente, o síndico realiza 
o cadastro das informações do morador, mas esse registro serve apenas para a gestão condominial. O porteiro não tem 
acesso a essas informações, nem realiza atividades sistêmicas.

No cenário atual, antes da implementação da solução proposta, o porteiro identifica qualquer visitante na portaria ao 
ligar para o apartamento do morador e solicitar permissão de entrada. De acordo com as regras do prédio, a entrada de 
veículos não pertencentes aos moradores não é permitida. Atualmente, o porteiro identifica o veículo do morador por 
meio de um adesivo
 
### O que queremos resolver com essa solução?
A aplicação visa facilitar o controle de acesso em um condomínio residencial, permitindo que o porteiro tenha 
informações disponíveis para consultar dados dos moradores, apartamentos e veículos. Essa aplicação possibilita ao 
porteiro cadastrar visitantes, incluindo informações como a data da visita. Além disso, os moradores têm a opção 
de agendar, junto ao porteiro, um período específico em que o visitante terá permissão de acesso ao prédio. 
Após a expiração desse período, é necessário realizar uma nova atualização de visita para manter o controle eficiente 
do acesso de visitantes.

### Como nossa solução resolverá o problema?

A aplicação proporcionará um melhor controle, com o cadastro e informações de visitante(s) e períodos em que 
os mesmos possam acessar o prédio. Atráves de consulta a uma api externa do cadastro de moradores, módulo realizado
pelo síndico, será disponibilizado um módulo de consulta para que o porteiro possa validar informações de veículos 
que acessam o prédio.

### Arquitetura
A arquitetura do projeto está no padrão MVC
Versão Java: 17
Versão SpringBoot: 3.1.2
Banco de Dados: h2 (Memória)

### CURL Postman

### Event Storming
![eventStorming.png](src%2Fmain%2Fresources%2FeventStorming.png)
Link do miro: https://miro.com/app/board/uXjVNStcDSI=/