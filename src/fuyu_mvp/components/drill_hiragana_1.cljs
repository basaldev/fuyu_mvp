(ns fuyu_mvp.components.drill-hiragana-1
  (:require [fuyu_mvp.components.letter :as letter]
            [fuyu_mvp.components.missing-pool :as pool]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn columns [words] (quot 12 (count words)))

(defn is-target? [selecting? word]
  (and selecting? (= word "　")))

(defn main [question missing options selection selecting? correct? select-word cancel-word decide-word]
  (let [cols (columns question)]
    [:div {:class "container"}
      [:div {:class "row"}
        (map (fn [word]
          (let [target? (is-target? selecting? word)] (letter/main word cols target? decide-word)))
          (remove-letter question missing))]
      [pool/main options selection select-word cancel-word]]))
