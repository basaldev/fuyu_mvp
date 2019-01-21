(ns fuyu_mvp.components.drill-hiragana-1
  (:require [fuyu_mvp.components.letter :as letter]
            [fuyu_mvp.components.missing-pool :as pool]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn columns [words] (quot 12 (count words)))

(defn randomize [answer others]
  (shuffle (conj (vec others) answer)))

(defn main [question missing options selecting? correct? select-word cancel-word decide-word]
  (let [words (vec question) cols (columns words) choices (randomize (words missing) options)]
    [:div {:class "container"}
      [:div {:class "row"}
        (map (fn [word] (letter/main word cols decide-word)) (remove-letter words missing))]
        [pool/main choices select-word]]))
