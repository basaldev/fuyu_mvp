(ns fuyu_mvp.components.letter
  (:require [clojure.string :as string]
            [goog.object :as object]))

(defn handle-drag-over [ev]
  (println "drag-over")
  (.preventDefault ev))

(defn handle-drag-enter [ev callback]
  (println "drag-enter")
  (println (object/get ev "target")))

(defn handle-drag-leave [ev callback]
  (println "drag-leave")
  (println (object/get ev "target")))

(defn handle-drop [ev selection callback]
  (println "drop")
  (println (object/get ev "target")))

(defn get-classes [target?]
  (string/join " " ["form-item" (if target? "is-target" "")]))

(let [style {"border" "1px solid"}]
  (defn main [letter column target? decide-word]
    [:div { :class (str "col-sm-" column) :key letter }
      [:div { :class (get-classes target?)
              :style style
              :on-drag-enter handle-drag-enter
              :on-drag-over handle-drag-over
              :on-drag-leave handle-drag-leave
              :on-drop (fn [ev] (handle-drop ev letter decide-word))}
                [:div {} letter]]]))
