(ns fuyu_mvp.components.letter
  (:require [clojure.string :as string]
            [goog.object :as object]))

(defn handle-drag-over [ev]
  (.preventDefault ev))

(defn handle-drag-enter [ev callback]
  (println "drag-enter")
  (callback))

(defn handle-drag-leave [ev callback]
  (println "drag-leave")
  (callback))

(defn handle-drop [ev callback]
  (println "drop")
  (callback selection))

(defn get-classes [target? hovering?]
  (string/join " " ["form-item" (if target? "is-target" "") (and target? (if hovering? "is-hover" ""))]))

(let [style {"border" "1px solid"}]
  (defn main [letter column target? hovering? decide-word enter-form leave-form]
    [:div { :class (str "col-sm-" column) :key letter }
      [:div { :class (get-classes target? hovering?)
              :style style
              :on-drag-over handle-drag-over
              :on-drag-enter (fn [ev] (handle-drag-enter ev enter-form))
              :on-drag-leave (fn [ev] (handle-drag-leave ev leave-form))
              :on-drop (fn [ev] (handle-drop ev decide-word))}
                [:div {} letter]]]))
