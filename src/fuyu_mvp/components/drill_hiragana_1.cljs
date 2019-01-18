(ns fuyu_mvp.components.drill-hiragana-1
  (:require [fuyu_mvp.components.letter :as letter]
            [fuyu_mvp.components.missing-pool :as pool]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn columns [words] (quot 12 (count words)))

(defn main [word missing]
  (let [words (vec word) cols (columns words)]
    [:div {:class "container"} 
      [:div {:class "row"}
        (map (fn [word] (letter/main word cols)) (remove-letter words missing))]
        [pool/main [(get words missing)]]]))
