(ns fuyu_mvp.components.form
  (:require [clojure.string :as string]
            [fuyu_mvp.components.form-letter :as letter]))

(defn remove-letter [word-v index]
  (assoc word-v index "　"))

(defn get-columns [words] (quot 12 (count words)))

(defn is-target? [selecting? word]
  (and selecting? (string/blank? word)))

(defn get-face [word answered? correct?]
  (if (string/blank? word) ""
    (if (and answered? correct?) "happy" "sad")))

(defn main [question missing options selection selecting? hovering? answered? correct? decide-word enter-form leave-form]
  (let [columns (get-columns question)]
    [:div {:class "container"}
      [:div {:class "question row"}
        (map-indexed (fn [index word]
          (let [target? (is-target? selecting? word) face (get-face word answered? correct?)]
            (letter/main index word face columns target? hovering? decide-word enter-form leave-form)))
          (if (and answered? correct?) question (remove-letter question missing)))]]))
