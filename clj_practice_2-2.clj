;; (defn prompt-int [prompt]
;;     (println prompt)
;;     (. Integer parseInt (read-line)))
;;
;; (defn fizz-or-buzz-or-number [number]
;;     (let [divisible-by-3 (= (mod number 3) 0)
;;           divisible-by-5 (= (mod number 5) 0)]
;;         (cond (and divisible-by-3 divisible-by-5) "fizz-buzz"
;;               divisible-by-3 "fizz"
;;               divisible-by-5 "buzz"
;;               :else number)))
;;
;; (defn fizz-buzz []
;;     (let [start (prompt-int "Enter in a start value")
;;           end (prompt-int "Enter in an end value")
;;           nums-in-range (range start (+ end 1))
;;           ;; range will not count the last integer
;;           final-output (map fizz-or-buzz-or-number nums-in-range)]
;;         (println "nums in range" final-output)))
;;
;; (fizz-buzz)

(defn prompt-int [prompt]
    (println prompt)
    (. Integer parseInt (read-line)))

(defn evenly-divisible [number divisor]
    (= (mod number divisor) 0))

(defn fizz-or-buzz-or-number [number]
    (let [divisible-by-3 (evenly-divisible number 3)
          divisible-by-5 (evenly-divisible number 5)]
        (cond (and divisible-by-3 divisible-by-5) "fizz-buzz"
              divisible-by-3 "fizz"
              divisible-by-5 "buzz"
              :else number)))

(defn fizz-buzz
  ([start end]
   (let [nums-in-range (range start (+ end 1))
         final-output (map fizz-or-buzz-or-number nums-in-range)]
       (doseq [result final-output]
           (println result))))

  ([]
   (let [start (prompt-int "Enter in a start value")
         end (prompt-int "Enter in an end value")]
    (fizz-buzz start end))))

(fizz-buzz)
