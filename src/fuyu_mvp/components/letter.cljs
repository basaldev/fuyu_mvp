(ns fuyu_mvp.components.letter
  (:require [goog.object :as object]
            [fuyu_mvp.components.face :as face]))

(defn handle-drag-over [ev]
  (println "drag-over")
  (.preventDefault ev))

(defn handle-drag-enter [ev callback]
  (println "drag-enter")
  (println (object/get ev "target")))

(defn handle-drag-leave [ev callback]
  (println "drag-leave")
  (println (object/get ev "target")))

(defn handle-drag-end [ev]
  (println "drag-end"))

(defn handle-drop [ev selection callback]
  (println "drop")
  (println (object/get ev "target")))

  (defn main [letter column decide-word]
    [:div { :class (str "col-sm-" column) :key letter }
      [:div { :class (str "form-item" (if (clojure.string/blank? letter) " open" ""))
              :on-drag-enter handle-drag-enter
              :on-drag-over handle-drag-over
              :on-drag-leave handle-drag-leave
              :on-drag-end handle-drag-end
              :on-drop (fn [ev] (handle-drop ev letter decide-word))}
                [:span {} letter]  [face/main "frown"]
                ]])
