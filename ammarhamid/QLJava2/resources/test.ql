form test
{
    "First name" name: string
    "Did you sell a house in 2010?" hasSoldHouse: boolean

    if(hasSoldHouse)
    {
        "What is the price of the house?" housePrice: integer
    }
    else
    {
        "Are you sure that you don't sell house in 2010?" sure: boolean
    }

    "Did you sell a car in 2010?" hasSoldCar: boolean

    if(hasSoldCar)
    {
        "What is the price of the car?" housePrice: integer
    }
    else
    {
        "Are you sure that you don't sell car in 2010?" sure: boolean
    }

    "Are you married?" married: boolean
}
