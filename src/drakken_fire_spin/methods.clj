(ns drakken-fire-spin.methods
  (:require [clojure.string :as s]))


(defn exhaust-input?
  "For each character in run-str
  take that same character out of db-str
  when run-str is exhausted successfully (there was a matching char in db-str for each char in run-str)
  return true."
  [run--str db--str]
   (loop [run-str (s/lower-case run--str)
          db-str (s/lower-case db--str)]
     (let [search (subs run-str 0 1)
           in? (s/includes? db-str search)
           r (s/replace-first db-str search "")
           remainer (+ (- (count r) (count db-str)) (count run-str))]
      ;(println search " | " in? " | " db-str " | " r " | " remainer)
       (if (not in?)
         nil
         (if (= 0 remainer)
           :consumed
           (when (> remainer 0)
             (recur (subs run-str 1) r)))))))

(defn scramble? [in ax]
  (exhaust-input? ax in))

;(exhaust-input? "soil" "deadforceoilsacks")
;(exhaust-input? "dance" "dancendancendance")
;(exhaust-input? "tribe" "riberiberiberibrebirb")
;(exhaust-input? "tax" "axmansT")
;(scramble? "rekqodlw" "world")
;(time (scramble? "cedewaraaossoqqyt" "codewars"))
;(time (scramble? "katas" "steak"))
;(scramble? "participationfeyerbend" "bend")

(->> (scramble? "zaxzaxzaxzaxzaxzaxzaxzaxzaxzaxczc" "cxzc")
     (time))

