;; (def get-name (fn [] "Mahoney, Mark R."))
;;
;; (get-name)

;; ---------------

;; There is a function called nth which will return an element from
;; a sequence.

;; All sequences are 0-based collections.

;; def is considererd as variable assignment
;; Returns the value at the index.

;; (def get-name (fn [first middle last]
;;                (str last ", " first " " (nth middle 0) ".")))
;;
;; (get-name "Mark" "Robert" "Mahoney")

;; ---------------

;; def and fn can be used to create a binding to a function.
;; defn is a shortcut to do the same thing.

;; (defn pass-fail? [grade]
;;     (if (>= grade 60) "pass" "fail"))

;; (pass-fail? 50) ;should be fail
;; (pass-fail? 100) ;should be pass

;; ---------------

;; If one expression evaluates to true all of the ones underneath
;; it are not evaluated.
;; :else is a keyword

;; (defn get-grade [grade]
;;     (cond (>= grade 90) "A"
;;           (>= grade 80) "B"
;;           (>= grade 70) "C"
;;           (>= grade 60) "D"
;;           :else "F"))
;;
;; (get-grade 95)
;; (get-grade 85)
;; (get-grade 75)
;; (get-grade 65)
;; (get-grade 55)

;; ---------------

;; (defn get-complete-grade-string [grade]
;;     (str grade " " (get-grade grade) " " (pass-fail? grade)))

;; (get-complete-grade-string 85)
;; (get-complete-grade-string 95)
;; (get-complete-grade-string 75)
;; (get-complete-grade-string 65)
;; (get-complete-grade-string 55)

;; ---------------

;; (defn get-grade-results [grades])

;; (defn get-grade-results [grades]
;;     (for [grade grades]
;;         (get-complete-grade-string grade)))

;; (get-grade-results '(78.0 84.0 96.0 74.0 52.0))

;; ---------------

;; (defn get-grade-results [grades]
;;     (map get-complete-grade-string grades))

;; def is a form that creates a global binding, let is one used to create a
;; local binding.
;;
;; A def is kind of like the declaration of a global variable in an imperative
;; language. let is kind of like declaring a local variable.

;; for and map iterate over a sequence. The difference is that the body of a
;; for can perform any operation on each value in the sequence. map
;; specifically sends each value into a single parameter function.

;; (defn get-grade-results [grades]
;;     (let [all-grades (map get-complete-grade-string grades)]))

;; (defn get-grade-results [grades]
;;     (let [all-grades (map get-complete-grade-string grades)]
;;         (apply str all-grades)))

;; (get-grade-results '(78.0 84.0 96.0 74.0 52.0))

;; This gets turned from this:
;;
;; (apply str '("78.0 C pass" "84.0 B pass" "96.0 A pass" "74.0 C pass" "52.0 F fail"))
;;
;; into this:
;;
;; (str "78.0 C pass" "84.0 B pass" "96.0 A pass" "74.0 C pass" "52.0 F fail")

;; (defn get-complete-grade-string [grade]
;;     (str grade " " (get-grade grade) " " (pass-fail? grade) "\n "))
;;
;; (defn get-grade-results [grades]
;;     (let [all-grades (map get-complete-grade-string grades)]
;;         (apply str all-grades)))

;; (get-grade-results '(78.0 84.0 96.0 74.0 52.0))

;; ---------------

;; (defn get-final-grade [grades])

;; (defn get-final-grade [grades]
;;     (let [sum-of-all-grades (reduce + grades)]
;;         (/ sum-of-all-grades (count grades))))
;;
;; (get-final-grade '(78.0 84.0 96.0 74.0 52.0))

;; ---------------

;; An & in a parameter list collects arguments and puts them into a sequence
;; that is accessible in the function.
;;
;; The sequence is called grades.

;; (defn print-student [first middle last & grades]
;;     (let [student-name (get-name first middle last)
;;           grade-results (get-grade-results grades)
;;           final-grade (get-final-grade grades)]
;;         (println student-name)
;;         (println "Grades: ")
;;         (println grade-results)
;;         (println "Final Grade: " final-grade (get-grade final-grade) (pass-fail? final-grade))
;;         (println)))
;;
;; (print-student "Mark" "Robert" "Mahoney" 78.0 84.0 96.0 74.0 52.0)

;; ---------------

(def get-name (fn [first middle last]
               (str last ", " first " " (nth middle 0) ".")))

(defn pass-fail? [grade]
    (if (>= grade 60) "pass" "fail"))

(defn get-grade [grade]
    (cond (>= grade 90) "A"
          (>= grade 80) "B"
          (>= grade 70) "C"
          (>= grade 60) "D"
          :else "F"))

(defn get-complete-grade-string [grade]
    (str grade " " (get-grade grade) " " (pass-fail? grade) "\n"))

(defn get-grade-results [grades]
    (let [all-grades (map get-complete-grade-string grades)]
        (apply str all-grades)))

(defn get-final-grade [grades]
    (let [sum-of-all-grades (reduce + grades)]
        (/ sum-of-all-grades (count grades))))

(defn print-student [first middle last & grades]
    (let [student-name (get-name first middle last)
          grade-results (get-grade-results grades)
          final-grade (get-final-grade grades)]
        (println student-name)
        (println "Grades: ")
        (println grade-results)
        (println "Final Grade: " final-grade (get-grade final-grade) (pass-fail? final-grade))
        (println)))

(print-student "Mark" "Robert" "Mahoney" 78.0 84.0 96.0 74.0 52.0)
