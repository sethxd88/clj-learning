(defn parse-int [s]
   (Integer/parseInt s))

(defn larger-or-divisible-by-five [number]
  (let [larger-than-5 (>= number 5)
        divisible-by-5 (= (mod number 5) 0)]
    (cond (= number 0) "0"
          (or larger-than-5 divisible-by-5) "1"
          :else "0")))

(defn ^String fake-bin [x]
  (let [digits (map (comp parse-int str) x)
        result (map larger-or-divisible-by-five digits)]
     (apply str result)))
     ;; (println (apply str result))))

(fake-bin "111565")
