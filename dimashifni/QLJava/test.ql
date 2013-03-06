form testQL {
    name : "what is your name bro? " string
    age : "what is your age bro? " integer
    age2 : "what is your age2 bro? " integer
    age3 : "Age difference: (age-age2) " integer(age-age2)
    hasSoldHouse2 : "did you just sell you house2! " boolean
    hasSoldHouse3 : "did you just sell you house3! " boolean
    if(hasSoldHouse2) {
        hasSoldHouse4 : "did you just sell you house4! " boolean
        watchPrice : "what is your watch price bro? " money
    }
    else {
        hasSoldHouse6 : "did you just sell you house6! " boolean
    }
    carPrice : "what is your car price bro? " integer
}
