(ns fuyu_mvp.domain.middlewares.init
  (:require [fuyu_mvp.domain.store :as store]))

(defn randomize [question options]
  (shuffle (conj options question)))

(defn get-answer [question missing]
  ((vec question) missing))

(defn init-words []
  (store/swap :options (randomize
    (get-answer (@store/state :question) (@store/state :missing))
    (@store/state :options))))
