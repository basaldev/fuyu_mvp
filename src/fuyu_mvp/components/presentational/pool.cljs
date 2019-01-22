(ns fuyu_mvp.components.pool
  (:require [fuyu_mvp.components.pool-letter :as letter]))

(defn is-dragging [selecting? letter selection]
  (and selecting? (= letter selection)))

(defn get-face [is-dragging? correct?]
  (if is-dragging?
    (if correct? "happy" "sad")
    "normal"))

(defn main [letters selection selecting? correct? select-word unselect-word]
  [:div { :class "row" }
    (map (fn [letter]
      (let [is-dragging? (is-dragging selecting? letter selection)
            face (get-face is-dragging? correct?)]
        [letter/main letter face is-dragging? select-word unselect-word])) letters)])