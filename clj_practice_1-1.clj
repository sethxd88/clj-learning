;; (def name "Seth")
;; (println "Hello" name "!!!")

(def number 1)
(+ number 2)
(println number)

(println "Enter name: " "haha" "xxx")

(println "Enter name: ")
(def name (read-line))
(println "Hello" name "!!!")


(println "Enter age: ")
;; (def age (read-line))
(def age (. Integer parseInt (read-line)))
(println name "your age is" age "in 10 years you will be" (+ 10 age))
