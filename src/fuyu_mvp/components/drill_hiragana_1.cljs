(ns fuyu_mvp.components.drill-hiragana-1
  (:require [fuyu_mvp.components.letter :as letter]
            [fuyu_mvp.components.missing-pool :as pool]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn main [word missing]
  (let [words (vec word)]
    [:div {:class "container"} 
      [:div {:class "row"}
        (map letter/main (remove-letter words missing))]
        [pool/main [(get words missing)]]]))
