form boxHouse1Owning {
    "Wat is je naam?" userName: string
    "Wat is je leeftijd?" userAge: integer
    if (userAge == 18) {
    	"U mag auto rijden: " allowedToDrive = userAge == 18
    }
}