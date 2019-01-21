(ns fuyu_mvp.components.drill-hiragana-1
  (:require [clojure.string :as string]
            [fuyu_mvp.components.letter :as letter]
            [fuyu_mvp.components.missing-pool :as pool]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn columns [words] (quot 12 (count words)))

(defn is-target? [selecting? word]
  (and selecting? (string/blank? word)))

(defn get-face [word answered? correct?]
  (if (string/blank? word) ""
    (if (and answered? correct?) "happy" "sad")))

(defn main [question missing options selection selecting? hovering? answered? correct? select-word unselect-word decide-word enter-form leave-form]
  (let [cols (columns question)]
    [:div {:class "container"}
      [:div {:class "row"}
        (map (fn [word]
          (let [target? (is-target? selecting? word) face (get-face word answered? correct?)]
            (letter/main word face cols target? hovering? decide-word enter-form leave-form)))
          (if (and answered? correct?) question (remove-letter question missing)))]
      [pool/main options selection selecting? correct? select-word unselect-word]]))
