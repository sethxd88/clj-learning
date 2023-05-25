(println "Enter in the dog's name: ")
(def dogs-name (read-line))

(println "Enter in the dog's age: ")
(def dogs-age (. Integer parseInt (read-line)))

(println dogs-name "'s human age is" (- dogs-age 1))
(println dogs-name "'s human age is" (* (- dogs-age 1) 7))
(println dogs-name "'s human age is" (+ (* (- dogs-age 1) 7) 1))
(println (str dogs-name "'s") "human age is" (+ (* (- dogs-age 1) 7) 1))

(println (str 'abc' "'s"))
(println (str "abc" "'s"))
